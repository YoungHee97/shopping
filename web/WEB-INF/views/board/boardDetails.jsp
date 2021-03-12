<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
    function getParameterByName(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
    $(document).ready(function () {
        document.getElementById("board_id").value = getParameterByName("boardId");
        getBoardDetails();
    });
    function goBoardList(){
        location.href = "/board/boardList";
    }
    function getBoardDetails() {
        $.ajax({
            url: "/board/getBoardDetails",
            data: $("#boardDetailsForm").serialize(),
            dataType: "JSON",
            cache: false,
            async: true,
            type: "POST",
            success: function (obj) {
                getBoardDetailsCallback(obj);
            },
            error: function (xhr, status, error) {
            }
        });
    }
    function getBoardDetailsCallback(obj) {
        var str = "";
        if (obj != null) {
            var boardTitle = obj.board_title;
            var boardContents = obj.board_contents;
            var memberNick = obj.member_nick;
            var boardDate = obj.board_date;
            $("#member_nick").text(memberNick);
            $("#board_date").text(boardDate);
            $("#board_title").text(boardTitle);
            $("#board_contents").html(boardContents);
        }
    }
    /** 게시판 - 삭제  */
    function deleteBoard(){
        var boardId = $("#board_id").val();
        var yn = confirm("게시글을 삭제하시겠습니까?");
        if(yn){
            $.ajax({
                url     : "/board/deleteBoard",
                data    : $("#board_id").serialize(),
                dataType: "JSON",
                cache   : false,
                async   : true,
                type    : "POST",
                beforeSend : function(xhr) {
                    xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
                },
                success : function(obj) {
                    deleteBoardCallback(obj);
                },
                error     : function(xhr, status, error) {}
            });
        }
    }
    /** 게시판 - 삭제 콜백 함수 */
    function deleteBoardCallback(obj){
        if(obj != null){
            var result = obj.result;
            if(result == "SUCCESS"){
                alert("게시글 삭제를 성공하였습니다.");
                goBoardList();
            } else {
                alert("게시글 삭제를 실패하였습니다.");
                return;
            }
        }
    }
    /** 게시판 - 수정 페이지 이동 */
    function goBoardUpdate(){
        var boardId = $("#board_id").val();
        location.href = "/board/boardUpdate?boardId="+ boardId;
    }
</script>

<div class="container">
    <form id="boardDetailsForm" name="boardDetailsForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" id="board_id" name="board_id" value="1"/>
        <div class="form-group row">
            <label for="member_nick" class="col-sm-2 col-form-label">작성자</label>
            <div class="col-sm-10" id="member_nick">
            </div>
        </div>
        <div class="form-group row">
            <label for="board_date" class="col-sm-2 col-form-label">작성일</label>
            <div class="col-sm-10" id="board_date">
            </div>
        </div>
        <div class="form-group row">
            <label for="board_title" class="col-sm-2 col-form-label">제목</label>
            <div class="col-sm-10" id="board_title">
            </div>
        </div>
        <div class="form-group row">
            <label for="board_contents" class="col-sm-2 col-form-label">내용</label>
            <div class="col-sm-10" id="board_contents">
            </div>
        </div>

        <span class="btn-group col-md-offset-9">
        <a href="/board/boardList" class="btn btn-default">목록</a>
        <a href="javascript: goBoardUpdate()" class="btn btn-default">수정</a>
        <a href ="javascript:deleteBoard()" class="btn btn-default">삭제</a>
    </span>

    </form>
</div>