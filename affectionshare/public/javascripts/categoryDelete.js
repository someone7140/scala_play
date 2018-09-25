$(function(){
    // カテゴリー削除ボタン押下
    $('.categorydeleteform').submit(function(){

        if(!window.confirm('本当に削除しても大丈夫ですか？')){
            // キャンセルの時の処理
            return false;
        }else{
            // OKの時の処理
            return true;
        }
    })

});