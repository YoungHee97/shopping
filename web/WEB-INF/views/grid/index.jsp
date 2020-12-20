
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script type="text/javascript" src="/resources/grid/node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/resources/grid/node_modules/tui-code-snippet/dist/tui-code-snippet.min.js"></script>
<script type="text/javascript" src="/resources/grid/node_modules/tui-time-picker/dist/tui-time-picker.min.js"></script>
<script type="text/javascript" src="/resources/grid/node_modules/tui-date-picker/dist/tui-date-picker.min.js"></script>
<script type="text/javascript" src="/resources/grid/node_modules/tui-grid/dist/tui-grid.min.js"></script>
<link rel="stylesheet" href="/resources/grid/node_modules/tui-time-picker/dist/tui-time-picker.css">
<link rel="stylesheet" href="/resources/grid/node_modules/tui-date-picker/dist/tui-date-picker.css">
<link rel="stylesheet" href="/resources/grid/node_modules/tui-grid/dist/tui-grid.min.css">


<style>
    *{
        margin: 0 auto;
    }
</style>

    <script>
        var grid;
        window.onload = function(){
            grid = new tui.Grid({
                el: document.getElementById('grid'),
                //data: gridData,
                scrollX: false,
                scrollY: false,
                rowHeaders: ["rowNum"],
                columns: [
                    {
                        header: 'Name',
                        name: 'name'
                    },
                    {
                        header: 'Artist',
                        name: 'artist'
                    },
                    {
                        header: 'Type',
                        name: 'type'
                    },
                    {
                        header: 'Release',
                        name: 'release'
                    },
                    {
                        header: 'Genre',
                        name: 'genre'
                    }
                ]
            });

            $('button').click(function(){
                $.ajax({
                    url: "/resources/js/index.js",
                    method: "GET",
                    type: "Json",
                    success: function(result){
                        grid.resetData(eval(result));
                    },
                });
            });
        };

        tui.Grid.applyTheme("normal",{
            cell:{
                normal:{
                    background: "#fff",
                    border: "#e0e0e0",
                    showVerticalBorder: false,
                    showHorizontalBorder: true,
                },
                header:{
                    background: "#eaeaea",
                    border: "#e0e0e0",
                    showHorizontalBorder: true,
                },
                rowHeader:{
                    background: "#eaeaea",
                    border: "#e0e0e0",
                    showHorizontalBorder: true,
                }
            },
        });
    </script>


<div class="container">

    <div style="display: flex; flex-flow: row nowrap; margin-bottom: 10px;">
        <div>
            <img src="/resources/grid/node_modules/bootstrap-icons/icons/chat-left-dots.svg"> grid 연습하기
        </div>
        <div>
            <button type="button" class="btn btn-primary btn-sm">데이터 받기</button>
        </div>
    </div>

    <div id="grid"></div>

</div>









