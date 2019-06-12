<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>게시판 목록</title>
    <link rel="stylesheet" type="text/css" href="style1.css">
    </head>
    <body>
    <div id = "total">
       <form name="searchForm" action="" method="get">
       <p>
           <select name="searchType">
               <option value="ALL">전체검색</option>
               <option value="SUBJECT">제목</option>
               <option value="WRITER">작성자</option>
               <option value="CONTENTS">내용</option>
           </select>
           <input type="text" name="searchText" value="" />
           <input type="submit" value="검색" />
       </p>
       </form>
       <table border="1" summary="게시판 목록">
           <caption>게시판 목록</caption>
           <colgroup>
               <col width="50" />
               <col width="300" />
               <col width="80" />
               <col width="100" />
               <col width="70" />
           </colgroup>  
           <thead>
               <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록 일시</th>
                    <th>조회수</th>
               </tr>
           </thead>
           <tbody>
               <tr>
                    <td align="center">1</td>
                    <td><a href="">중고차 판매합니다.</a></td>
                    <td align="center">최주호</td>
                    <td align="center">2019.06.03</td>
                    <td align="center">11</td>
               </tr>
           </tbody>
           <tfoot>
               <tr>
                    <td align="center" colspan="5">1</td>
               </tr>
           </tfoot>
       </table>
       <p>
           <input type="button" value="목록" onclick="" />
           <input type="button" value="글쓰기" onclick="" />
       </p>
       </div>
</body>
</html>
