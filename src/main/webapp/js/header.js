$(function (){
    //绑定改变事件
    $("#category").on("change",function (){
        let  cid =$(this).val();
        //使用ajax
        $.get("books?action=findByCid",{"cid":cid},function (data){
            location.reload();
        })
    })



})