<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="/resources/css/good/good.css" rel="stylesheet">
<link href="/resources/css/good/list.css" rel="stylesheet">

<div class="container">

<div class="goods_list">
    <div class="goods_list_cont">
        <!-- 상품 리스트 -->
        <div class="item_gallery_type">

            <ul>
                <li  style="width:25%;">
                    <div class="item_cont">
                        <div class="item_photo_box" >
                            <a href="${pageContext.request.contextPath}/dress/good/a">
                                <img src="/resources/images/dress/a.jpg" width="180" alt="사이키델릭 알파카 티셔츠" title="사이키델릭 알파카 티셔츠" class="middle"  />
                            </a>
                        </div>
                        <div class="item_info_cont">
                            <div class="item_tit_box">
                                <a href="${pageContext.request.contextPath}/dress/good/a">
                                    <strong class="item_name">사이키델릭 알파카 티셔츠</strong>
                                </a>
                            </div>
                            <div class="item_money_box">
                                <strong class="item_price">
                                    <span >KRW36,000 </span>
                                </strong>
                            </div>
                            <div class="item_icon_box">
                            </div>
                        </div>
                    </div>
                </li>

                <li  style="width:25%;">
                    <div class="item_cont">
                        <div class="item_photo_box" >
                            <a href="${pageContext.request.contextPath}/dress/good/b" >
                                <img src="/resources/images/dress/b.jpg" width="180" alt="SKT1 유니폼" title="SKT1 유니폼" class="middle"  />
                            </a>
                        </div>
                        <div class="item_info_cont">
                            <div class="item_tit_box">
                                <a href="${pageContext.request.contextPath}/dress/good/b">
                                    <strong class="item_name">SKT1 유니폼</strong>
                                </a>
                            </div>
                            <div class="item_money_box">
                                <strong class="item_price">
                                    <span >KRW24,000 </span>
                                </strong>
                            </div>
                            <div class="item_icon_box">
                            </div>
                        </div>
                    </div>
                </li>

                <li  style="width:25%;">
                    <div class="item_cont">
                        <div class="item_photo_box" >
                            <a href="${pageContext.request.contextPath}/dress/good/c" >
                                <img src="/resources/images/dress/c.jpg" width="180" alt="drx 리버스 반팔 유니폼" title="drx 리버스 반팔 유니폼" class="middle"  />
                            </a>
                        </div>
                        <div class="item_info_cont">
                            <div class="item_tit_box">
                                <a href="${pageContext.request.contextPath}/dress/good/c">
                                    <strong class="item_name">drx 리버스 반팔 유니폼</strong>
                                </a>
                            </div>
                            <div class="item_money_box">
                                <strong class="item_price">
                                    <span >KRW59,000 </span>
                                </strong>
                            </div>
                            <div class="item_icon_box">
                            </div>
                        </div>
                    </div>
                </li>


                <li  style="width:25%;">
                    <div class="item_cont">
                        <div class="item_photo_box" >
                            <a href="${pageContext.request.contextPath}/dress/good/d" >
                                <img src="/resources/images/dress/d.png" width="180" alt="젠지 유니폼" title="젠지 유니폼" class="middle"  />
                            </a>
                        </div>
                        <div class="item_info_cont">
                            <div class="item_tit_box">
                                <a href="${pageContext.request.contextPath}/dress/good/d">
                                    <strong class="item_name">젠지 유니폼</strong>
                                </a>
                            </div>
                            <div class="item_money_box">
                                <strong class="item_price">
                                    <span >KRW34,000 </span>
                                </strong>
                            </div>
                            <div class="item_icon_box">
                            </div>
                        </div>
                    </div>
                </li>


        </div>

    </div>
</div>
</div>
</div>

<!-- //item_gallery_type -->
<!-- //상품 리스트 -->
</div>
</div>

<div class="pagination">
    <div class="pagination"><ul><li class="on"><span>1</span></li></ul></div>
</div>

</div>
<!-- //goods_list_item -->
<script type="text/javascript">
    $(document).ready(function () {

        $('form[name=frmList] select[name=pageNum]').change(function() {
            $('form[name=frmList]').get(0).submit();
        });

        $('form[name=frmList] input[name=sort]').click(function() {
            $('form[name=frmList]').get(0).submit();
        });

        $(':radio[name="sort"][value=""]').prop("checked","checked")
        $(':radio[name="sort"][value=""]').next().addClass('on');

    });
</script>
</div>
</div>

