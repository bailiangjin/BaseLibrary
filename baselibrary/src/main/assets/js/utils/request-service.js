;
var queryService = {
    // 示例
    Sample: function() {
        this.querySampleList = function() {
            var url = "http://dataup.cn/paisheguifan-app/result.json";
            var json = suzhou.http.get(url, {});
            json = $.parseJSON(json);
            return json;
        }
    },
    // 做任务服务
    MakeTask: function() {
        // 查询未认领任务
        this.queryTaskList = function(fn, pageNum) {
            suzhou.geolocation.getLocation(function(data) {
                var locationData = $.parseJSON(data);
                /**
                    * 该处的数据需要从后台动态获取
                    */
                var prm = {
                    "ownerId": suzhou.constant.ownerId(),
                    "page": pageNum,
                    "radis": "3000",
                    "size": "5",
                    "userName": suzhou.constant.userName(),
                    "x": locationData.x,
                    "y": locationData.y
                };
                var url = suzhou.constant.collectUrl() + "/queryTaskByRd?";
                var json = suzhou.http.post(url, {
                    "content": JSON.stringify(prm)
                });
                if (null == json || json == undefined) {
                    alert("获取服务端数据失败。。");
                    return;
                }
                //将服务端返回的数据格式化成jsoN对象
                var jsonData = JSON.parse(json);
                fn(jsonData);
            });
        };
        //领取任务
        this.claimTask = function(data) {
            var url = suzhou.constant.collectUrl() + "/receiveTask?";
            var prms = {
                "ownerId": suzhou.constant.ownerId(),
                "basePackageId": data.basePackageId,
                "taskPackageId": data.taskPackageId,
                "userName": suzhou.constant.userName(),
            };
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prms)
            });
            if (null == json || json == undefined) {
                alert("获取服务端数据失败。。");
                return false;
            }
            //将服务端返回的数据格式化成jsoN对象
            var jsonData = JSON.parse(json);
            if (jsonData.status.code == 0) {
                alert("领取成功！");
                return true;
            } else {
                alert(jsonData.status.msg);
                return false;
            }
        };
    },
    //获取我的任务各个列表的数据
    MyTask: function() {
        //获取已领取任务
        this.getTaskList = function(taskStatus, pageNum) {
            var url = suzhou.constant.collectUrl() + "/queryTaskPackage?";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "taskStatus": taskStatus,
                "page": pageNum,
                "size": "5",
                "userName": suzhou.constant.userName(),
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //获取数据列表
        this.getTaskDetailList = function(basePackageId, taskStatus, pageNum) {
            var url = suzhou.constant.collectUrl() + "/queryPackageTasks?";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "taskStatus": taskStatus,
                "page": pageNum,
                "size": "10",
                "basePackageId": basePackageId,
                "userName": suzhou.constant.userName(),
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //删除我的步骤
        this.deleteTaskDetailItemList = function(data, extraListData) {
            var url = suzhou.constant.collectUrl() + "/saveTask?";
            //获取需要传递的参数
            var prm = {
                "baseId": data.baseId,
                "collectClassId": data.collectClassId,
                "dataName": data.dataName,
                "deviceInfo": suzhou.constant.Imei(),
                "extras": [{
                    "batchId": extraListData.batchId,
                    "level": extraListData.level,
                    "operation": "1",
                    //1代表是删除
                    "value": {
                        "collectClassId": extraListData.collectClassId,
                        "money": extraListData.money
                    }
                }],
                "ownerId": suzhou.constant.ownerId(),
                "taskId": data.taskId,
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //增加主动任务
        this.creationTaskNet = function(data, dataName) {
            var url = suzhou.constant.collectUrl() + "/saveTask?";
            //获取需要传递的参数
            var prm = {
                "collectClassDistance": data.collectClassDistance,
                "collectClassId": data.id,
                "collectClassName": data.collectClassName,
                "collectClassType": data.collectClassType,
                "collectCount": data.collectCount,
                "createTime": data.createTime,
                "dataName": dataName,
                "deviceInfo": suzhou.constant.Imei(),
                "entranceStatus": data.entranceStatus,
                "isRequired": data.isRequired,
                "ownerId": suzhou.constant.ownerId(),
                "status": data.status,
                "updateTime": data.updateTime,
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //删除待提交里面的单项
        this.deleteTaskList = function(data) {
            var url = suzhou.constant.collectUrl() + "/deletePackage?";
            //获取需要传递的参数
            var prm = {
                "deleteInfo": [{
                    "basePackageId": data.basePackageId,
                    "taskPackageId": data.taskPackageId
                }],
                "ownerId": suzhou.constant.ownerId(),
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //申诉
        this.appEal = function(basePackageId) {
            var url = suzhou.constant.collectUrl() + "/reAuditApply?";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "basePackageId": basePackageId,
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //获取附近的任务点
        this.getTaskPoint = function(x, y) {
            var url = suzhou.constant.collectUrl() + "/queryAllTaskByRd?";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "radis": "3000",
                "x": x,
                "y": y,
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, {
                "content": JSON.stringify(prm)
            });
            var jsonData = JSON.parse(json);
            return jsonData;
        };
        //获取该任务的主动任务类型
        this.getActivityTask = function() {
            var url = suzhou.constant.ccUrl() + "/openapi?";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "serviceid": "666003",
                "userName": suzhou.constant.userName()
            };
            //获取到从服务器获取到的已经领取的任务列表
            var json = suzhou.http.post(url, prm);
            var jsonData = JSON.parse(json);
            return jsonData;
        }
    },
    //获取h5版本号
    PageUtils: function() {
        this.getPageLastVersion = function(data) {
            //这里要用h5的服务器的地址
            var url = suzhou.constant.ccUrl() + "htmlPage/getVersionNo.html";
            //获取需要传递的参数
            var prm = {
                "ownerId": suzhou.constant.ownerId(),
                "collectClassParentId": data.collectClassId,
                "collectClassId": "0",
                "entranceStatus": "1"
            };
            //获取版本号这个是h5是键值对的形式
            var json = suzhou.http.post(url, prm);
            var jsonData = JSON.parse(json);
            console.info("PageUtils====" + json);
            return jsonData;
        }
    }

}