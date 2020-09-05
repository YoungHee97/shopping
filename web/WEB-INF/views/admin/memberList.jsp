
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(document).ready(function () {
        getMemberList();
    });

    function getMemberList() {
        $.ajax({
            url: "/admin/getMemberList",
            data: $("#memberForm").serialize(),
            dataType: "JSON",
            cache: false,
            async: true,
            type: "POST",
            success: function (obj) {
                getMemberListCallback(obj);
            },
            error: function (xhr, status, error) {

            }
        });
    }

    function getMemberListCallback(obj) {
        var str = "";
        if (obj.length > 0) {
            for (var a = 0; a < obj.length; a++) {
                var memberId = obj[a].member_id;
                var memberNick = obj[a].member_nick;
                var memberEmail = obj[a].member_email;
                var memberPassword = obj[a].member_password;

                str += "<tr>";
                str += "<td>" + memberId + "</td>";
                str += "<td>" + memberNick + "</td>";
                str += "<td>" + memberEmail + "</td>";
                str += "<td>" + memberPassword + "</td>";
                str += "</tr>";
            }
        }

        $("#tbody").html(str);
    }

    function doExcelDownloadProcess(){
        var f = document.excelForm;
        f.action = "downloadExcelFile?_csrf=${_csrf.token}";
        f.submit();
    }

    function doExcelUploadProcess(){
        var f = new FormData(document.getElementById('excelForm'));
        $.ajax({
            url: "/admin/uploadExcelFile",
            data: f,
            processData: false,
            contentType: false,
            type: "POST",
            beforeSend : function(xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function(obj) {
                location.href = obj;
            }
        })
    }
</script>

<div class="container">
    <form id="memberForm" name="memberForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <table class="table table-striped">
            <colgroup>
                <col width="20%"/>
                <col width="20%"/>
                <col width="20%"/>
                <col width="20%"/>
            </colgroup>
            <thead>
            <tr>
                <th>아이디</th>
                <th>닉네임</th>
                <th>이메일</th>
                <th>비밀번호</th>
            </tr>
            </thead>
            <tbody id="tbody">
            </tbody>
        </table>
    </form>

    <form id="excelForm" name="excelForm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="file" id="fileInput" name="fileInput">
        <button type="button" onclick="doExcelUploadProcess()">엑셀업로드 작업</button>
        <button type="button" onclick="doExcelDownloadProcess()">엑셀다운로드 작업</button>
    </form>

    
</div>
