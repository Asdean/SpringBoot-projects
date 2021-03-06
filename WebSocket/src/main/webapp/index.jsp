<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <title>SpringBoot+WebSocket+JSP</title>
</head>

<body style="margin: 45px;">
    <h4>websocket</h4>
    <div class="form-group">
        <label for="content"></label>
        <textarea id="content" readonly="readonly" cols="80" rows="15"></textarea>
    </div>
    <div class="form-group" style="margin-top: 8px">
        <textarea id="message" cols="80" rows="5" placeholder="请输入消息"></textarea>
        <div style="margin-top: 10px">
            <button id="toSend" class="btn btn-info">发送</button>
            <button id="exit" class="btn btn-danger">离开</button>
        </div>
    </div>

    <script type="text/javascript">
        //页面加载完毕，触发该js函数
        $(function () {
            var ws;
            //判断浏览器是否支持websocket
            if ("WebSocket" in window) {
                //ajax 2006年 支持了 XMLHttpRequest
                var baseUrl = 'ws://localhost:8080/websocket/123';
                //建立与服务端的websocket连接
                ws = new WebSocket(baseUrl);

                // 连通之后的回调事件，建立连接
                ws.onopen = function () {
                    console.log("建立 websocket 连接...");
                };

                // 接收后台服务端的消息
                ws.onmessage = function (event) {
                    $('#content').append(event.data + '\n\n');
                    console.log("接收到服务端发送的消息..." + event.data + '\n');
                };

                ws.onerror = function (event) {
                    console.log("websocket发生错误..." + event + '\n');
                }

                // 连接关闭的回调事件
                ws.onclose = function () {
                    $('#content').append('[' + userName + '] 已离开!');
                    console.log("关闭 websocket 连接...");
                };

            } else {
                // 浏览器不支持 WebSocket
                alert("您的浏览器不支持WebSocket!");
            }

            // 客户端发送消息到服务器
            $('#toSend').click(function () {
                sendMsg();
            });

            $(document).keyup(function (event) {
                // 回车键事件
                if (event.keyCode == 13) {
                    sendMsg();
                }
            });

            // 发送消息
            function sendMsg() {
                //websocket发送消息
                ws.send($('#message').val());
            }

            // 退出
            $('#exit').click(function () {
                if (ws) {
                    ws.close();
                }
            });
        });
    </script>
</body>
</html>