<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="search-section">
    <div class="container">
        <div class="row subscribe-from">
            <div class="col-md-12">
                <form class="form-inline col-md-12 wow fadeInDown animated">
                    <div class="form-group">
                        <input type="email" class="form-control subscribe" id="email" placeholder="Search...">
                        <button class="suscribe-btn" ><i class="pe-7s-search"></i></button>
                    </div>
                </form><!-- end /. form -->
            </div>
        </div><!-- end of/. row -->
    </div><!-- end of /.container -->
</section><!-- end of /.news letter section -->

<script type="text/javascript">
    var msg = '${msg}';
    if (msg != "") alert(msg);
</script>

<script type="text/javascript">
    $(document).ready(function () {
        getBoardList();
    });
    function getBoardList() {
        $.ajax({
            url: "/board/getBoardList",
            data: $("#boardForm").serialize(),
            dataType: "JSON",
            cache: false,
            async: true,
            type: "POST",
            success: function (obj) {
                getBoardListCallback(obj);
            },
            error: function (xhr, status, error) {
            }
        });
    }
    function getBoardListCallback(obj) {
        var str = "";
        if (obj.length > 0) {
            for (var a = 0; a < obj.length; a++) {
                var boardId = obj[a].board_id;
                var boardTitle = obj[a].board_title;
                var memberNick = obj[a].member_nick;
                var boardDate = obj[a].board_date;
                var boardHits = obj[a].board_hits;
                str += "<tr>";
                str += "<td>" + boardId + "</td>";
                str += "<td>" + "<a href=\"/board/boardDetails?boardId=" + boardId + "\">" + boardTitle + "</a></td>";
                str += "<td>" + memberNick + "</td>";
                str += "<td>" + boardHits + "</td>";
                str += "<td>" + boardDate + "</td>";
                str += "</tr>";
            }
        }
        $("#tbody").html(str);
    }
</script>


<div class="container">
    <form id="boardForm" name="boardForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table id="boardForm-table" class="table table-striped">
            <colgroup>
                <col width="10%"/>
                <col width="40%"/>
                <col width="20%"/>
                <col width="10%"/>
                <col width="20%"/>
            </colgroup>
            <thead id="thead">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성일</th>
            </tr>
            </thead>

            <tbody id="tbody">
            </tbody>

            <tfoot id="tfoot">
            <tr>
                <td colspan="4">
                    <a href="/board/boardWrite">글 작성</a>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>

</div>
