;
var taskPageUtils = {
    //刷新 列表头部信息
    refreshAnnotation: function(annotation, priFix, count, postFix) {
        $(annotation).html(priFix + count + postFix);
    },

    //已领取
    refreshReceivedAnnotation: function(annotation, count) {
        this.refreshAnnotation(annotation, "已领取", count, "条（请在5个工作日内提交）");
    },

    //待提交
    refreshWaitSubmitAnnotation: function(annotation, count) {
        this.refreshAnnotation(annotation, "待提交", count, "条");
    },

    //审核中
    refreshCheckingAnnotation: function(annotation, count) {
        this.refreshAnnotation(annotation, "审核中", count, "条");
    },

    //已审核
    refreshCheckedAnnotation: function(annotationPass, passedCount, annotationFail, failedCount) {
        this.refreshAnnotation(annotationPass, "初审通过:", passedCount, "条");
        this.refreshAnnotation(annotationFail, "初审未通过，可申诉:", failedCount, "条(申诉有效期:1个工作日");
    },

    //待结算
    refreshWaitSettlementAnnotation: function(annotationPass, passedCount, annotationFail, failedCount) {
        this.refreshAnnotation(annotationPass, "最终审核通过:", passedCount, "条");
        this.refreshAnnotation(annotationFail, "最终审核未通过", failedCount, "条");
    },

}