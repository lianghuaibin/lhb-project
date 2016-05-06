var common={
    dotHtml : function(tmpl, data) {
        _html = $(tmpl).html();
        var tpl = doT.template(_html);
        var html = tpl(data);
        return html;
    },
    postData : function(url, parameter, callback) {
        $.ajax({
            type : "POST",
            url : url,
            dataType : "json",
            data : parameter,
            success : function(data) {
                if (callback == null) {
                    return;
                }
                callback(data);
            },
            error : function(error) {
                alert('网络不给力:(');
                console.log(error);
            }
        });
    },

    /**
     * alert弹框
     * @param content
     */
    alertInfo:function(content){
        alert(content);
    }
}