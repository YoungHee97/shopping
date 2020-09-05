<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/classic/ckeditor.js"></script>

<style type="text/css">
    .ck-editor__editable {
        min-height: 300px;
    }
</style>

<div class="container">
    <form role="form" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
        .catch( error => {
            console.error( error );
        } );
</script>
