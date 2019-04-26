import java.awt.{Color, Font, RenderingHints}
import java.awt.image.BufferedImage
import java.io.{File, FileOutputStream}

import javax.imageio.{IIOImage, ImageIO, ImageWriteParam}

object ImageWritingWordSample extends App {
  // 元画像の読み込み
  val originalImage = ImageIO.read(new File(s"resources/200x50.png"))

  // 新規画像に元画像を組み込み
  val newImage = new BufferedImage(320, 50, originalImage.getType)
  val graphics = newImage.createGraphics()
  graphics.drawImage(originalImage, 0, 0, null)

  // 文字を書くところの背景色
  graphics.setColor(Color.WHITE)
  graphics.fillRect(200, 0, 320, 50)

  // フォントの設定
  graphics.setFont(new Font("Arial", Font.PLAIN, 12))
  // 文字色
  graphics.setColor(Color.BLACK)
  // アンチエイリアス
  graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
  // 文字の追加
  graphics.drawString("テストテスト", 210,20)
  graphics.drawString("テストテスト", 210,40)

  // 画像出力
  val os = new FileOutputStream("resources/new_320x50.jpeg")
  val ios = ImageIO.createImageOutputStream(os)
  val writer = ImageIO.getImageWritersByFormatName("jpeg").next
  val param = writer.getDefaultWriteParam
  param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT)
  // 画像品質の設定
  param.setCompressionQuality(1.0f)
  writer.setOutput(ios)
  writer.write(null, new IIOImage(newImage, null, null), param)
  writer.dispose()
}
