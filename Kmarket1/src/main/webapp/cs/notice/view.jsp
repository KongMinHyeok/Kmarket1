<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../_header.jsp"/>
      <section id="cs">
        <div class="notice">
          <nav>
            <div>
              <p>홈<span>></span>공지사항</p>
            </div>
          </nav>
          <section class="view">
            <aside>
              <h2>공지사항</h2>
              <ul>
                <li class="${cate eq null ? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do">전체</a></li>
                <li class="${cate.equals('service')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=service">고객서비스</a></li>
                <li class="${cate.equals('safe')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=safe">안전거래</a></li>
                <li class="${cate.equals('product')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=product">위해상품</a></li>
                <li class="${cate.equals('event')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=event">이벤트당첨</a></li>
              </ul>
            </aside>
            <article>
              <nav>
                <h2 class="title">${notice.title}</h2>
                <span class="date">${notice.rdate}</span>
              </nav>

              <div class="content">
                <p>${notice.content}</p>
                <p>
                  ※ 피싱 관련 피해신고<br /><br />
                  ▶ 경찰청 사이버수사국 (국번없이)182 :
                  <a href="http://cyberbureau.police.go.kr">http://cyberbureau.police.go.kr</a> <br />
                  ▶ KISA 인터넷침해대응센터 (국번없이)118 :
                  <a href="http://www.krcert.or.kr">http://www.krcert.or.kr</a><br />
                  감사합니다.<br />
                </p>
              </div>
              <a href="/Kmarket1/cs/notice/list.do?cate=${notice.cate}" class="btnList">목록보기</a>
            </article>  
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>