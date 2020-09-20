
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/classic/ckeditor.js"></script>

<style type="text/css">
    .ck-editor__editable {
        min-height: 300px;
    }
</style>

<script type="text/javascript">
    var CKEditor;
    function setContentsValue() {
        var editorData = CKEditor.getData();
        $("#board_contents").val(editorData);
    }

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
    });


</script>

<div class="container">
    <form role="form" method="post" onsubmit="setContentsValue(); return true;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" id="board_id" name="board_id" value="1"/>
        <div class="form-group row">
            <label for="board_title" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="board_title" name="board_title">
            </div>
        </div>
        <div class="form-group row">
            <label for="board_contents" class="col-sm-2 col-form-label">Contents</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="board_contents" name="board_contents">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>

</div>

<script>
    ClassicEditor
        .create( document.querySelector( '#board_contents' ) )
        .then(editor => {
            CKEditor = editor;
        })
        .catch( error => {
            console.error( error );
        } );

</script>


