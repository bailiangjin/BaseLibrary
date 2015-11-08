;
var requestUrl{
    //根url
    ccUrl:suzhou.constant.ccUrl(),
    collectUrl:suzhou.constant.collectUrl(),



    //具体接口url

    //拍摄规范 url
    standardUrl:"http://dataup.cn/paisheguifan-app/result.json",

    //获取h5版本号
    getVersionNoUrl:ccUrl + "htmlPage/getVersionNo.html",
    //获取主动任务类型url
    openApiUrl:ccUrl + "/openapi?",
    //获取已领取任务
    receiveTaskUrl:collectUrl + "/receiveTask?"
    receiveTaskUrl:collectUrl + "/receiveTask?",
    //获取我的任务各个列表的数据
    queryTaskPackageUrl:collectUrl + "/queryTaskPackage?",
    queryPackageTasksUrl:collectUrl + "/queryPackageTasks?",
    saveTaskUrl:collectUrl + "/saveTask?",
    deletePackageUrl:collectUrl+ "/deletePackage?",
    //申诉url
    reAuditApplyUrl:collectUrl + "/reAuditApply?",
    //获取附近的任务点
    queryAllTaskByRdUrl:collectUrl + "/queryAllTaskByRd?",

    queryTaskByRdUrl:collectUrl + "/queryTaskByRd?",



}