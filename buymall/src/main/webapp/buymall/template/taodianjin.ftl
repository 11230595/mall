<#if product??>
<a data-type="0" id="alink" biz-itemid="${product.numIid!''}" style="display:none;" data-tmpl="470x190" data-tmplid="1111" data-rd="2" data-style="2" data-border="1" href="${product.itemUrl!''}"></a>
<script type="text/javascript">
    (function(win,doc){
        var s = doc.createElement("script"), h = doc.getElementsByTagName("head")[0];
        if (!win.alimamatk_show) {
            s.charset = "gbk";
            s.async = true;
            s.src = "http://a.alimama.cn/tkapi.js";
            h.insertBefore(s, h.firstChild);
        };
        var o = {
            pid: "mm_18774322_11774819_41732376",/*推广单元ID，用于区分不同的推广渠道*/
            appkey: "23271271",/*通过TOP平台申请的appkey，设置后引导成交会关联appkey*/
            unid: "",/*自定义统计字段*/
            type: "click" /* click 组件的入口标志 （使用click组件必设）*/
        };
        win.alimamatk_onload = win.alimamatk_onload || [];
        win.alimamatk_onload.push(o);
    })(window,document);
</script>
<#else>
参数有误
</#if>