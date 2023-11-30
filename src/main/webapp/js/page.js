function  changePage(flag){
    //获取到当前页
    let currentPage = $("#currentPage").val();
    //获取到总页数
    let countPage = $("#countPage").html();
    let res =0;
    //判断falg
    if(flag=="-"){
        //将currentPage转为int类型  再计算
        res = currentPage==1?currentPage:parseInt(currentPage)-1;
    }else if(flag=="+"){
        //将currentPage转为int类型  再计算
        res = currentPage==countPage?currentPage:parseInt(currentPage)+1;
    }

    //ajax请求分页查询
    $.get("books?action=findAllPage",{"currentPage":res},function (data){
        window.location.reload();


    })

}