	var conAreaCode = '';
	var conSigunguCode = '';
	
	//상세 보여주기
	function goContentListView(data) {
		
		if( data.body.article[0].contentStatus != '2' ) {
			location.href = '/main/main.do';
		}

		if( data.body.article[0].otdTitle == undefined || data.body.article[0].otdTitle == '' ) {
			document.title = data.body.article[0].title;
		} else {
			document.title = data.body.article[0].title+'|'+data.body.article[0].otdTitle;
		}

		uid = data.header.id;
		setLogintype(uid);
		
		$('.tit_cont h2').html(data.body.article[0].title);
		contitle = data.body.article[0].title;
		conTelno = data.body.article[0].telNo;
		conInfoCenter = data.body.article[0].infoCenter;
		if( data.body.article[0].overView != undefined ) {
			$('.area_txtView p').html(data.body.article[0].overView.replace(/(\n|\r\n)/g, '<br>'));			
		}

        var fareaname = getAreaName(data.body.article[0].areaCode);
        var fsigunguname = getSigunguName(data.body.article[0].areaCode, data.body.article[0].sigunguCode);

		$('.address').html(fareaname + ' ' + fsigunguname);
		
/*		if( data.body.article[0].sigunguName != undefined ) {
			if( data.body.article[0].areaName == data.body.article[0].sigunguName ) {
				$('.address').html(data.body.article[0].areaName);				
			} else {
				$('.address').html(dfareaname + ' ' + fsigunguname);
			}
			
		} else {
			$('.address').html(data.body.article[0].areaName);
		}
*/
		if( setDist(data.body.article[0].distance) == 'd' || setDist(data.body.article[0].distance) > 10000 ) {
			$('#dist').html('');
		} else {
			$('#dist').html('내 위치에서 '+setDist(data.body.article[0].distance) + 'km');			
		}

		
		sContentTitle = data.body.article[0].title;
		
		sContentId = data.body.article[0].cotId;
		sContentType = data.body.article[0].contentType;

		conLocationx = data.body.article[0].mapX;
		conLocationy = data.body.article[0].mapY;
		
        var rtagname;
        var rtagid;
        if( data.body.article[0].tagName != null ) {
           	rtagname = data.body.article[0].tagName.split("|");
            rtagid = data.body.article[0].tagId.split("|");
    		var strHtmltag = "";

            for (var i in rtagname) {  
            	strHtmltag += '<a href=javascript:goList("'+data.body.article[0].contentType+'","'+rtagname[i]+'","'+rtagid[i]+'")>'+'#'+rtagname[i]+'</span>'; 
            }  
        }
        
        conAreaCode = data.body.article[0].areaCode;
        conSigunguCode = data.body.article[0].sigunguCode;

        var strHtml = '';
        var strHtmlm = '';
        var strHtmlv = '';
        
        var imgcnt = data.body.image.length;
        
        if( imgcnt != 0 ) {
        	
    		$.each(data.body.image, function (index, items) {
    			
    			if( index == 0 ) {
    				sContentImg = items.imgPath;		//data.body.article[0].imgPath;
    			}
    			
    			var imgalt = items.imgAlt;
    			if( imgalt == null || imgalt == '' || imgalt == 'null' ) imgalt = data.body.article[0].title;

    			if( index <= 1 ) {
    				strHtml += '<li>';
    				strHtml += '<button type="button"><img src="'+mainimgurl+items.imgPath+'" alt="'+imgalt+'"></button>';
    				strHtml += '</li>';
    			}
    			
    			strHtmlm += '<div class="swiper-slide"><img src="'+mainimgurl+items.imgPath+'" alt="'+imgalt+'"></div>';

    	        strHtmlv += '<div class="swiper-slide">';
    	        strHtmlv += '    <div class="swiper-zoom-container"><img src="'+mainimgurl+items.imgPath+'" alt="'+imgalt+'"></div>';
    	        strHtmlv += ' </div>';

    		});
        	
        } else {
			strHtml += '<li>';
			strHtml += '<button type="button"><img src="/resources/images/common/no_img_01.png" alt="이미지없음"></button>';
			strHtml += '</li>';
			
			strHtmlm += '<div class="swiper-slide"><img src="/resources/images/common/no_img_01.png" alt=""이미지없음"></div>';

	        strHtmlv += '<div class="swiper-slide">';
	        strHtmlv += '    <div class="swiper-zoom-container"><img src="/resources/images/common/no_img_01.png" alt=""이미지없음"></div>';
	        strHtmlv += ' </div>';
			
        }

		//$('#ogtitle').attr('content', data.body.article[0].title);
		//$('#ogimage').attr('content', 'https://support.visitkorea.or.kr/img/call?cmd=VIEW&id='+sContentImg);
		//$('#ogurl').attr('content', 'https://korean.visitkorea.or.kr/detail/detail_view.do?cotid='+cotid);
        //$('#contentimage img').attr("src", 'https://support.visitkorea.or.kr/img/call?cmd=VIEW&id='+sContentImg);
        		
        $('.area_imgView ul').html(strHtml);
        $('#picmore').html('사진 더보기('+imgcnt+')');
        $('#imgviewm').html(strHtmlm);
        $('#imgviewBig').html(strHtmlv);
        $('.tag').html(strHtmltag);
        
        swiperContaine();
        swiperContaine2();
        
        strHtml = '';
    	var fesStatus = '';
    	
        if( data.body.article[0].contentType == '15' ) {
        	
			if( data.body.article[0].startDate == undefined || data.body.article[0].startDate == '' || data.body.article[0].endDate == undefined || data.body.article[0].endDate == '' ) {
				fesStatus += '<em class="flag type_plan">예정</em>';
			} else if( data.body.article[0].startDate > curDate ) {
				fesStatus += '<em class="flag type_before">진행전</em>';
			} else if( data.body.article[0].startDate.substring(4,8) == '0101' && data.body.article[0].endDate.substring(4,8) == '1231' ) {
				fesStatus += '<em class="flag type_always">상시</em>';
			} else if( data.body.article[0].startDate <= curDate && data.body.article[0].endDate >= curDate ) {
				fesStatus += '<em class="flag type_ing">진행중</em>';
			} else if( data.body.article[0].endDate < curDate ) {
				fesStatus += '<em class="flag type_end">종료</em>';
			}
			
			$('#fesstatus').html(fesStatus);
        	
	        strHtml += '<li><strong>시작일</strong><span>'+conDateFormat(data.body.article[0].startDate,"yyyyMMdd",".")+'</span></li>';
	        strHtml += '<li><strong>종료일</strong><span>'+conDateFormat(data.body.article[0].endDate,"yyyyMMdd",".")+'</span></li>';
	        
	        if( data.body.article[0].telNo1 == null || data.body.article[0].telNo1 == '' || data.body.article[0].telNo1 == 'null' ) {
	        	$('.link_phone').hide();
	        } else {
		        //전화걸기
				$('.link_phone a').attr("href", "tel:"+data.body.article[0].telNo1);	//conTelno
	        }
        } else {
	        if( conInfoCenter == null || conInfoCenter == '' || conInfoCenter == 'null' ) {
	        	$('.link_phone').hide();
	        } else {
	        	
		        var telArry = '';
		      
		        if( conInfoCenter.indexOf(',') > -1  ) {
			        telArry = conInfoCenter.split(",");		        	
		        } else if( conInfoCenter.indexOf('<br />') > -1 ) {
		        	telArry = conInfoCenter.split("<br />");
		        	if( telArry[0].indexOf('~') > -1  ) {
			        	telArry = conInfoCenter.split("~");
		        	}	
		        } else if( conInfoCenter.indexOf('<br/>') > -1  ) {
		        	telArry = conInfoCenter.split("<br/>");
		        	if( telArry[0].indexOf('~') > -1  ) {
			        	telArry = conInfoCenter.split("~");
		        	}	
		        } else if( conInfoCenter.indexOf('<br>') > -1  ) {
		        	telArry = conInfoCenter.split("<br>");
		        	if( telArry[0].indexOf('~') > -1  ) {
			        	telArry = conInfoCenter.split("~");
		        	}	
		        } else if( conInfoCenter.indexOf('~') > -1  ) {
		        	telArry = conInfoCenter.split("~");
		        } else if( conInfoCenter.indexOf('/') > -1  ) {
		        	telArry = conInfoCenter.split("/");
		        } else {
		        	telArry = [ conInfoCenter, ''];
		        }
  	    	
	        	//전화걸기
				$('.link_phone a').attr("href", "tel:"+telArry[0]);	//conTelno
	        }
        }

        if( data.body.article[0].infoCenter == null || data.body.article[0].infoCenter == '' || data.body.article[0].infoCenter == 'null' ) {
        } else {
        	strHtml += '<li><strong>문의 및 안내</strong><span>'+data.body.article[0].infoCenter+'</span></li>';
        }
        
        if( data.body.article[0].contentType == '15' ) {
	        if( data.body.article[0].telNo1 == null || data.body.article[0].telNo1 == '' || data.body.article[0].telNo1 == 'null' ) {
	        } else {
	            strHtml += '<li><strong>전화번호</strong><span>'+data.body.article[0].telNo1+'</span></li>';        	
	        }
        }

        if( data.body.article[0].homepage == null || data.body.article[0].homepage == '' || data.body.article[0].homepage == 'null' ) {
        } else {
            strHtml += '<li><strong>홈페이지</strong><span>'+data.body.article[0].homepage+'</span></li>';        	
        }

        if( data.body.article[0].addr1 == undefined || data.body.article[0].addr1 == 'null' ) {
        } else {
            strHtml += '<li><strong>주소</strong><span>'+data.body.article[0].addr1+'</span></li>';        	
        }

        if( data.body.article[0].sponsor1 == null || data.body.article[0].sponsor1 == '' || data.body.article[0].sponsor1 == 'null' ) {
        } else {
            strHtml += '<li><strong>주최</strong><span>'+data.body.article[0].sponsor1+'</span></li>';        	
        }
        if( data.body.article[0].sponsor2 == null || data.body.article[0].sponsor2 == '' || data.body.article[0].sponsor2 == 'null' ) {
        } else {
            strHtml += '<li><strong>주관</strong><span>'+data.body.article[0].sponsor2+'</span></li>';        	
        }
       
        if( data.body.article[0].restDate == null || data.body.article[0].restDate == '' || data.body.article[0].restDate == 'null' ) {
        } else {
        	strHtml += '<li><strong>휴일</strong><span>'+data.body.article[0].restDate+'</span></li>';
        }

        if( data.body.article[0].parking == null || data.body.article[0].parking == '' || data.body.article[0].parking == 'null' ) {
        } else {
        	strHtml += '<li><strong>주차</strong><span>'+data.body.article[0].parking+'</span></li>';
        }

        if( data.body.article[0].useCash == null || data.body.article[0].useCash == '' || data.body.article[0].useCash == 'null' || data.body.article[0].useCash == '' ) {
        } else {
        	strHtml += '<li><strong>이용요금</strong><span>'+data.body.article[0].useCash+'</span></li>';
        }

//        if( data.body.article[0].useTime == null || data.body.article[0].useTime == '' || data.body.article[0].useTime == 'null' ) {
//        } else {
//        	strHtml += '<li><strong>이용시간</strong><span>'+data.body.article[0].useTime+'</span></li>';
//        }
		if( data.body.article[0].setStatus == null || data.body.article[0].setStatus == '' || data.body.article[0].setStatus == 'null' ) {
		} else {
			strHtml += '<li><strong>지정현황</strong><span>'+data.body.article[0].setStatus+'</span></li>';
		}

        // 숙박
        if( data.body.article[0].accomCount == null || data.body.article[0].accomCount == '' || data.body.article[0].accomCount == 'null' ) {
        } else {
        	strHtml += '<li><strong>수용인원</strong><span>'+data.body.article[0].accomCount+'</span></li>';
        }

        if( data.body.article[0].checkInTime == null || data.body.article[0].checkInTime == '' || data.body.article[0].checkInTime == 'null' ) {
        } else {
        	strHtml += '<li><strong>입실시간</strong><span>'+data.body.article[0].checkInTime+'</span></li>';
        }

        if( data.body.article[0].checkOutTime == null || data.body.article[0].checkOutTime == '' || data.body.article[0].checkOutTime == 'null' ) {
        } else {
        	strHtml += '<li><strong>퇴실시간</strong><span>'+data.body.article[0].checkOutTime+'</span></li>';
        }

        if( data.body.article[0].chkCooking == null || data.body.article[0].chkCooking == '' || data.body.article[0].chkCooking == 'null' ) {
        } else {
        	strHtml += '<li><strong>객실내 취사 여부</strong><span>'+data.body.article[0].chkCooking+'</span></li>';
        }

        if( data.body.article[0].foodPlace == null || data.body.article[0].foodPlace == '' || data.body.article[0].foodPlace == 'null' ) {
        } else {
        	strHtml += '<li><strong>식음료장</strong><span>'+data.body.article[0].foodPlace+'</span></li>';
        }

//        if( data.body.article[0].contentType == '32' ) {
//       } else {
//            if( data.body.article[0].contactInfo == null || data.body.article[0].contactInfo == '' || data.body.article[0].contactInfo == 'null' ) {
//            } else {
//            	strHtml += '<li><strong>문의및안내</strong><span>'+data.body.article[0].contactInfo+'</span></li>';
//            }
//        }	

        if( data.body.article[0].pickup == null || data.body.article[0].pickup == '' || data.body.article[0].pickup == 'null' ) {
        } else {
        	strHtml += '<li><strong>픽업서비스</strong><span>'+data.body.article[0].pickup+'</span></li>';
        }

        if( data.body.article[0].seat == null || data.body.article[0].seat == '' || data.body.article[0].seat == 'null' ) {
        } else {
        	strHtml += '<li><strong>좌석수</strong><span>'+data.body.article[0].seat+'</span></li>';
        }

        if( data.body.article[0].firstMenu == null || data.body.article[0].firstMenu == '' || data.body.article[0].firstMenu == 'null' ) {
        } else {
        	strHtml += '<li><strong>대표메뉴</strong><span>'+data.body.article[0].firstMenu+'</span></li>';
        }
        if( data.body.article[0].treatMenu == null || data.body.article[0].treatMenu == '' || data.body.article[0].treatMenu == 'null' ) {
        } else {
        	strHtml += '<li><strong>취급메뉴</strong><span>'+data.body.article[0].treatMenu+'</span></li>';
        }

        if( data.body.article[0].roomCount == null || data.body.article[0].roomCount == '' || data.body.article[0].roomCount == 'null' ) {
        } else {
        	strHtml += '<li><strong>객실수</strong><span>'+data.body.article[0].roomCount+'</span></li>';
        }
        
        if( data.body.article[0].reservation == null || data.body.article[0].reservation == '' || data.body.article[0].reservation == 'null' ) {
        } else {
        	strHtml += '<li><strong>예약안내</strong><span>'+data.body.article[0].reservation+'</span></li>';
        }
        
        if( data.body.article[0].reservationUrl == null || data.body.article[0].reservationUrl == '' || data.body.article[0].reservationUrl == 'null' ) {
        } else {
        	strHtml += '<li><strong>예약안내 홈페이지</strong><span>'+data.body.article[0].reservationUrl+'</span></li>';
        }

        if( data.body.article[0].roomType == null || data.body.article[0].roomType == '' || data.body.article[0].roomType == 'null' ) {
        } else {
        	strHtml += '<li><strong>객실유형</strong><span>'+data.body.article[0].roomType+'</span></li>';
        }

        if( data.body.article[0].scale == null || data.body.article[0].scale == '' || data.body.article[0].scale == 'null' ) {
        } else {
        	strHtml += '<li><strong>규모</strong><span>'+data.body.article[0].scale+'</span></li>';
        }

        if( data.body.article[0].subFacility == null || data.body.article[0].subFacility == '' || data.body.article[0].subFacility == 'null' ) {
        } else {
        	strHtml += '<li><strong>부대시설</strong><span>'+data.body.article[0].subFacility+'</span></li>';
        }

        if( data.body.article[0].barbecue == null || data.body.article[0].barbecue == '' || data.body.article[0].barbecue == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].barbecue == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>바비큐장여부</strong><span>'+bbq+'</span></li>';
        }

        if( data.body.article[0].beauty == null || data.body.article[0].beauty == '' || data.body.article[0].beauty == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].beauty == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>뷰티시설여부</strong><span>'+bbq+'</span></li>';
        }
        
        if( data.body.article[0].bicycle == null || data.body.article[0].bicycle == '' || data.body.article[0].bicycle == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].bicycle == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>자전거 대여 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].compfire == null || data.body.article[0].compfire == '' || data.body.article[0].compfire == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].compfire == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>캠프파이어 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].fitness == null || data.body.article[0].fitness == '' || data.body.article[0].fitness == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].fitness == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>휘티니스 센터 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].karaoke == null || data.body.article[0].karaoke == '' || data.body.article[0].karaoke == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].karaoke == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>노래방 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].publicBath == null || data.body.article[0].publicBath == '' || data.body.article[0].publicBath == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].publicBath == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>공용 샤워실 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].publicPc == null || data.body.article[0].publicPc == '' || data.body.article[0].publicPc == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].publicPc == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>공용 PC실 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].sauna == null || data.body.article[0].sauna == '' || data.body.article[0].sauna == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].sauna == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>사우나실 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].seminar == null || data.body.article[0].seminar == '' || data.body.article[0].seminar == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].seminar == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>세미나실 여부</strong><span>'+bbq+'</span></li>';
        }	

        if( data.body.article[0].sports == null || data.body.article[0].sports == '' || data.body.article[0].sports == 'null' ) {
        } else {
        	var bbq = (data.body.article[0].sports == 1) ? "있음" : "없음";
        	strHtml += '<li><strong>스포츠 시설  여부</strong><span>'+bbq+'</span></li>';
        }	
        
        if( data.body.article[0].contentType == '15' ) {
        	var overview = '';

        	if( data.body.subArticle != undefined ) {
        		$.each(data.body.subArticle, function (index, items) {
        			if( index != 0 ) {
        				overview += '<br><br>['+items.title+']<br>';
        			}
        			overview += items.notice.replace(/(\n|\r\n)/g, '<br>');
        		});
        		
        		if( data.body.article[0].overView == undefined ) {
        			$('.area_txtView p').html(overview);
        		} else {
        			if( data.body.article[0].overView.length < overview.length ) {
        				$('.area_txtView p').html(overview);
        			}
        		}
            }
  
        } else {

	       	if( data.body.subArticle != undefined ) {
	      		$.each(data.body.subArticle, function (index, items) {

	      			if( ctrim(items.displayTitle) == '입장료' || ctrim(items.displayTitle) == '시설이용료' ) {
	      				var dislaytitle = items.displayTitle;
	      				if( ctrim(dislaytitle) == '입장료' || ctrim(dislaytitle) == '시설이용료' ) dislaytitle = '이용요금';
	      				
	      				if( items.contentBody == null || items.contentBody == '' || items.contentBody == 'null' ) {
	      				} else {
	      					strHtml += '<li><strong>'+dislaytitle+'</strong><span>'+items.contentBody+'</span></li>';	      					
	      				}
	      			}
	       		});
	        }
        	
        }
        
		$('.area_txtView ul').html(strHtml);
		
		detailHeight();

		strHtml = '';

        if( data.body.barrierFree != undefined && data.body.barrierFree != null ) {
    		$.each(data.body.barrierFree, function (index, items) {
    			strHtml += '<li><em>'+items.TITLE+'</em><p>'+items.DETAIL_TEXT+'</p></li>';
 
    			if( items.TITLE == '화장실') $('#b1').addClass('active');
    			else if( items.TITLE == '엘리베이터' ) $('#b2').addClass('active');
    			else if( items.TITLE == '주차' ) $('#b3').addClass('active');
    			else if( items.TITLE == '출입통로' || items.TITLE == '접근로' ) $('#b4').addClass('active');
    			else if( items.TITLE == '대중교통' ) {
    				$('#b5').addClass('active');
    				$('#b6').addClass('active');
    			} else if( items.TITLE == '휠체어' ) $('#b7').addClass('active');
    			else if( items.TITLE == '점자블록' || items.TITLE == '안내요원' || items.TITLE == '오디오가이드' || items.TITLE == '큰활자홍보물' || items.TITLE == '점자홍보물 및 점자표지판' || items.TITLE == '유도안내설비' ) $('#b8').addClass('active');
    			else if( items.TITLE == '수화안내' || items.TITLE == '자막 비디오가이드 및 영상자막안내' || items.TITLE == '청각장애 기타상세' ) $('#b9').addClass('active');
    			else if( items.TITLE == '수유실' ) $('#b10').addClass('active');
    			else if( items.TITLE == '지체장애 객실' || items.TITLE == '청각장애 객실' || items.TITLE == '객실' ) $('#b11').addClass('active');
    			else if( items.TITLE == '유모차' ) $('#b12').addClass('active');
    			
    		});

    		if( data.body.barrierFree.length == 0 ) {
            	$('#bfreeinfoH').removeClass('active');
            	$('#bfreeinfoH').hide();
            	$('#bfreeinfoB').hide();
    		} else {
                $('.pictogram_list').html(strHtml);
    		}
        } else {
        	$('#bfreeinfoH').removeClass('active');
        	$('#bfreeinfoH').hide();
        	$('#bfreeinfoB').hide();
        }

        strHtml = '';
//		if( data.body.article[0].deptView != undefined ) {
//			strHtml += '<div class="row">';
//			strHtml += '<strong>담당부서 : '+data.body.article[0].deptView+'</strong> <strong>등록 및 수정문의 : '+data.body.article[0].tel+'</strong>';
//			strHtml += '</div>';

			//strHtml = '<strong>담당부서 : '+data.body.article[0].deptView+'</strong> <strong>등록 및 수정문의 : '+data.body.article[0].tel+'</strong>';
//			$('.btm_team .inr').html(strHtml);
//		}

//		strHtml = '';
		
		// 객실정보
		if( data.body.accommo != undefined ) {
			
			$.each(data.body.accommo, function (index, items) {
				if( items.roomTitle != undefined && items.roomOffSeasonMF1 != undefined ) {
					strHtml += '<li>';
					strHtml += '<strong>'+items.roomTitle+'</strong>';
					
					strHtml += '<div class="slider_wrap swiper-container">';
					strHtml += '<ul class="swiper-wrapper">';
					
					var roomimgcnt = 0;
					for( var i=1; i<6;i++) {
						if( eval("items.roomImg"+i) != undefined  ) {		//&& eval("items.roomImg"+i) != 'null'
							roomimgcnt++;
							strHtml += '<li href="javascript:" class="swiper-slide">';
							strHtml += '	<a href="javascript:"><img src="'+mainimgurl+eval("items.roomImg"+i)+'" alt="'+items.roomTitle+'"></a>';
							strHtml += '</li>';
						}
					}
					
					if( roomimgcnt == 0) {
						strHtml += '<li href="javascript:" class="swiper-slide">';
						strHtml += '	<a href="javascript:"><img src="/resources/images/common/no_img_02.png" alt="이미지없음"></a>';
						strHtml += '</li>';
					}
	
					strHtml += '</ul>';
					
					//if( roomimgcnt > 1 ) {
						strHtml += '<div class="swiper-pagination"></div>';
						strHtml += '<button type="button" class="swiper-button-prev">이전</button>';
						strHtml += '<button type="button" class="swiper-button-next">다음</button>';
					//}
					strHtml += '</div>';
					
					strHtml += '<table>';
					strHtml += '	<caption>'+items.roomTitle+' 객실에 대한 내용이며, 객실크기, 숙박인원, 요금(비수기주중, 비수기주말, 성수기주중, 성수기주말, 일반 주중, 일반 주말), 부대시설 등으로 분류되어 정보를 제공함</caption>';
					strHtml += '	<colgroup>';
					strHtml += '		<col style="width:110px">';
					strHtml += '		<col>';
					strHtml += '	</colgroup>';
					strHtml += '	<tbody>';
					strHtml += '		<tr>';
					strHtml += '			<th>객실크기</th>';
					strHtml += '			<td>'+items.roomSize2+'m²</td>';
					strHtml += '		</tr>';
					strHtml += '		<tr>';
					strHtml += '			<th>숙박인원</th>';
					strHtml += '			<td> '+items.roomBaseCount+'명 (최대 '+items.roomMaxCount+'명)</td>';
					strHtml += '		</tr>';
					strHtml += '		<tr>';
					strHtml += '			<th>비수기주중</th>';
					if( items.roomOffSeasonMF1 == undefined || items.roomOffSeasonMF1 == 'null' || items.roomOffSeasonMF1 == 0 ) {
						strHtml += '			<td>-</td>';
					} else {
						strHtml += '			<td>'+numberWithCommas(items.roomOffSeasonMF1)+'원</td>';						
					}

					strHtml += '		</tr>';
					strHtml += '		<tr>';
					strHtml += '			<th>비수기주말</th>';
					if( items.roomOffSeasonMF2 == undefined || items.roomOffSeasonMF2 == 'null' || items.roomOffSeasonMF2 == 0 ) {
						strHtml += '			<td>-</td>';						
					} else {
						strHtml += '			<td>'+numberWithCommas(items.roomOffSeasonMF2)+'원</td>';
					}

					strHtml += '		</tr>';
					strHtml += '		<tr>';
					strHtml += '			<th>성수기주중</th>';
					if( items.roomPeakSeasonMF1 == undefined || items.roomPeakSeasonMF1 == 'null' || items.roomPeakSeasonMF1 == 0 ) {
						strHtml += '			<td>-</td>';						
					} else {
						strHtml += '			<td>'+numberWithCommas(items.roomPeakSeasonMF1)+'원</td>';
					}
					
					strHtml += '		</tr>';
					strHtml += '		<tr>';
					strHtml += '			<th>성수기주말</th>';

					if( items.roomPeakSeasonMF2 == undefined || items.roomPeakSeasonMF2 == 'null' || items.roomPeakSeasonMF2 == 0 ) {
						strHtml += '			<td>-</td>';						
					} else {
						strHtml += '			<td>'+numberWithCommas(items.roomPeakSeasonMF2)+'원</td>';
					}

					strHtml += '		</tr>';
					strHtml += '<tr>';
					strHtml += '<th class="va_t">부대시설</th>';
					var budae = '';
					if( items.roomBathFacility == 'Y' ) { budae += '목욕시설'; } 
					if( items.roomBath == 'Y' ) {	budae += ',욕조'; } 
					if( items.roomAirConditioner == 'Y' ) { budae += ',에어콘'; } 
					if( items.roomTv == 'Y' ) { budae += ',TV'; } 
					if( items.roomInternet == 'Y' ) { budae += ',인터넷'; } 
					if( items.roomPc == 'Y' ) { budae += ',PC'; } 
					if( items.roomRefrigerator == 'Y' ) { budae += ',냉장고'; } 
					if( items.roomHomTheater == 'Y' ) { budae += ',홈씨어터'; } 
					if( items.roomSofa == 'Y' ) { budae += ',쇼파'; } 
					if( items.roomTable == 'Y' ) { budae += ',테이블';	} 
					if( items.roomToiletries == 'Y' ) { budae += ',세면도구'; }
					if( items.roomCook == 'Y' ) { budae += ',취사용품'; }
					if( items.roomCable == 'Y' ) { budae += ',케이블설치'; } 
					if( items.roomHairdryer == 'Y' ) { budae += ',헤어드라이기'; } 
					
					if( budae.substring(0,1) == ',' ) { budae = budae.substring(1, budae.length); }
					
					strHtml += '<td>'+budae+'</td>';
					strHtml += '		</tr>';
					strHtml += '	</tbody>';
					strHtml += '</table>';
					strHtml += '</li>';
				}	
			});
			
			$('.room_guide_list ul').html(strHtml);

			swiperRoomguide();
			
			if( data.body.accommo != null && data.body.accommo.length > 0 ) {
				$('#roomtoggle').addClass('active');
				//$('.title_btn_toggle').show();
				//$('.room_guide_list').show();
			} else {
				$('#roomtoggle').hide();
				$('.room_guide_list').hide();
			}
			

		}
	};    
	
	
	function getContentMapList(kind) {
		
		if( conLocationy == undefined || conLocationy == 'undefined' || conLocationy == 'null' ) {
			$('#staticMap').parents('li').hide();
			$('.link_mapsearch').hide();
			$('.link_navi').hide();
		} else {
			var markerPosition  = new daum.maps.LatLng(conLocationy, conLocationx); 
	   		var marker = {
	   			    position: markerPosition
	   			};

	   		var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
	   	    staticMapOption = { 
	   	        center: new daum.maps.LatLng(conLocationy, conLocationx), // 이미지 지도의 중심좌표
	   	        level: 7, // 이미지 지도의 확대 레벨
	   	        marker: marker // 이미지 지도에 표시할 마커 
	   	    };    

	      	// 이미지 지도를 생성합니다
	      	var staticMap = new daum.maps.StaticMap(staticMapContainer, staticMapOption);
	      	
	      	//길찾기
	      	var title = contitle;
	      	var lx = conLocationx;
	      	var ly = conLocationy;

	      	$('.link_mapsearch a').attr("href", "http://map.daum.net/link/to/"+title.replace(/\//gi,"_").replace(/,/gi,".")+","+ly+","+lx).attr("target","_blank");
	      	$('#staticMap img').attr("alt", contitle + ' 위치 지도_새창');
	 	}

     	
      	//var roadviewClient = new daum.maps.RoadviewClient(),
        //position2 = new daum.maps.LatLng(ly, lx);
      	//var panoid = '';
      	
      	//roadviewClient.getNearestPanoId(position2, 500, function(panoId) {
      	//	panoid = panoId;
          	//로드뷰 
    		//$('.link_map a').attr("href", "http://map.daum.net/link/roadview/"+lx+","+ly).attr("target","_blank");
        //  /$('.link_map a').attr("href", "http://map.daum.net/?panoid="+panoid).attr("target","_blank");
      	//});
    
      	getContentAddList(kind);
	}
  	
 		
	//sns link 가져오기
	function getContentAddList(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_ADD_LIST_VIEW',
				cotid : cotid
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentAddListView(data,kind);
			},
			complete: function() {
				getContentChargeInfo(1);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
    //sns link 보여주기.
	function goContentAddListView(data,kind) {
		
		var strHtml = '';
		
		if( data.body.result !=  undefined ) {
			$.each(data.body.result, function (index, items) {
				
				if( items.linkType == '0') {
					strHtml += '<li>';
				} else {
					strHtml += '<li class="full_img">';
				}
				strHtml += '<a href="'+items.linkUrl+'" title="'+items.displayTitle+'" target="_blank"  style="background-color:'+items.backColor+'">';

				if( items.linkType == '0') {
					strHtml += '	<em style="color:'+items.textColor+'">'+items.displayTitle+'</em><img src="'+mainimgurl+items.imgPath+'" alt=""></a>';
				} else {
					strHtml += '<img src="'+mainimgurl+items.imgPath+'" alt="'+items.displayTitle+'">';
				}

				strHtml += '</li>';
			});			
			
			$('.list_banner').append(strHtml);
		}	
	}
	
	
	//담당자 가져오기
	function getContentChargeInfo(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_CHARGE_INFO_VIEW',
				contentKind : kind+'',
				cotid : cotid,
				otdid : '0a01eb7b-96de-11e8-8165-020027310001'
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentChargeInfoView(data,kind);
			},
			complete: function() {
				//getContentRecomInfo(kind);
				if( kind == 1 ) {
					getContentRecomInfoAuto(kind);					
				}
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}

	//당당자 표시하기
	function goContentChargeInfoView(data,kind) {
		var strHtml = '';

		if( data.body.result != undefined ) {
			var resultcnt = data.body.result.length;
			
			$.each(data.body.result, function (index, items) {
			
				if( kind == 0 && resultcnt >= 2 ) {
					if( items.kind == 1 ) {
						strHtml += '<div class="row">';
						strHtml += '<strong>담당부서 : '+items.DEP_NAME+'</strong> <strong>등록 및 수정문의 : '+items.DEP_TEL+'</strong>';
						strHtml += '</div>';
					}
				} else {
					strHtml += '<div class="row">';
					strHtml += '<strong>담당부서 : '+items.DEP_NAME+'</strong> <strong>등록 및 수정문의 : '+items.DEP_TEL+'</strong>';
					strHtml += '</div>';
				}
			});	

			$('.btm_team .inr').html(strHtml);
			
			btnTeam();
		}

	}
	
	//연관추천 가져오기
	function getContentRecomInfo(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_RECOM_INFO_VIEW',
				cotid : cotid
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentRecomInfoView(data,kind);
			},
			complete: function() {
				getContentCourseInfo(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관추천 표시하기
	function goContentRecomInfoView(data,kind) {
		
		var strHtml = '';
		var retemp = '&temp=';
		
		if( data.body.result != undefined ) {
			
			$.each(data.body.result, function (index, items) {
	            strHtml += '<li>';
	            strHtml += '    <a href="../detail/rem_detail.do?cotid='+items.cotId+retemp+'">'+items.title+'</a>';
	            
	            var fareaname = getAreaName(items.areaCode);
	            var fsigunguname = getSigunguName(items.areaCode, items.sigunguCode);

	            strHtml += '    <span>'+fareaname+' '+fsigunguname+'</span>';            	

	            strHtml += '</li>';
	            
	            if( index >= 1 ) return false;
			});
			
			$('.list_recom').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.box_recom').show();
			}
			
		}
	}

	//연관코스 가져오기
	function getContentCourseInfo(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_COURSE_INFO_VIEW',
				cotid : cotid
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentCourseInfoView(data,kind);
			},
			complete: function() {
				getContentTourInfo(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관코스 표시하기
	function goContentCourseInfoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {
		    	strHtml += '<div class="course_des">';
		    	strHtml += '<a href="../detail/cs_detail.do?cotid='+items.cotId+'"><strong>'+items.title+'</strong>';
		    	strHtml += '<ul>';
		    	
	            var fareaname = getAreaName(items.areaCode);
	            var fsigunguname = getSigunguName(items.areaCode, items.sigunguCode);

		    	strHtml += '<li>지역 : '+fareaname+' '+fsigunguname+'</li>';	    		
	
		    	strHtml += '<li>코스 총거리 : '+items.distance+'</li>';
		    	strHtml += '</ul></a>';
		    	strHtml += '<img src="'+mainimgurl+items.imgPath1+'" alt="" class="img_thumBg">';
		    	strHtml += '</div>';
		    	strHtml += '<ul>';
	
		        var courseList = items.courseList.split("|");  
	
	            for (var i in courseList) {  
	   				strHtml += '<li><span>'+courseList[i]+'</li>';
	   			}	
		    	strHtml += '</ul>';
	
	            if( index >= 0 ) return false;
			});
			
			$('.area_course').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.tit_rc').show();
				$('.box_course').show();
			}
			
		}	
	}

	//연관명소 가져오기
	function getContentTourInfo(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_TOUR_INFO_VIEW',
				cotid : cotid
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentTourInfoView(data,kind);
			},
			complete: function() {
				getContentFestivalInfo(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관명소 표시하기
	function goContentTourInfoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {

		        strHtml += '<li>';
		       	strHtml += '<a href="../detail/ms_detail.do?cotid='+items.cotId+'">';
		       	strHtml += '    <div class="img_area">';
		       	strHtml += '    	<img src="../resources/images/common/img_dummy.png" alt="">';
		       	strHtml += '		<span class="img" style="background-image:url('+mainimgurl+items.imgPath1+');"></span>';
		       	strHtml += '	</div>';
		       	strHtml += '    <strong>'+items.title+'</strong>';
		       	strHtml += '</a>';
		       	strHtml += '</li>';
	
	            if( index >= 3 ) return false;
			});
			
			$('.box_thumRecom ul').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.tit_rc').show();
				$('.box_thumRecom').show();
			}
		}	
	}

	//연관축제 가져오기
	function getContentFestivalInfo(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_FESTIVAL_INFO_VIEW',
				cotid : cotid
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentFestivalInfoView(data,kind);
			},
			complete: function() {
				if( kind != 'Recom') {
					mason();
				}	

				getContentCommentInfo();
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관축제 표시하기
	function goContentFestivalInfoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {
				
				strHtml += '<a href="/detail/fes_detail.do?cotid='+items.cotId+'"><img src="'+mainimgurl+items.imgPath1+'" alt="'+items.title+'"></a>';
				strHtml += '<strong class="tit">'+items.title+'</strong>';

				if( index >= 0 ) return false;
			});	
			 
			$('.box_festival .banner').html(strHtml);
			
			if( data.body.result.length > 0 ) {
				$('.tit_rc').show();
				$('.box_festival').show();
			}

		}
			
	}
	
	
	function swiperContaine() {
		var swiper = new Swiper('.area_imgView_m .swiper-container', { // 0823 클래스 추가
			pagination: {
				el: '.area_imgView_m .swiper-pagination', // 0828 수정
				type: 'fraction',
			},
			navigation: {
				nextEl: '.area_imgView_m swiper-button-next',// 1107 클래스 area_imgView_m 추가
				prevEl: '.area_imgView_m swiper-button-prev',// 1107 클래스 area_imgView_m 추가
			}
		});
	}

	function swiperContaine2() {
		var swiper1 = new Swiper('.swiper-container1', {
		    zoom: true,
		    pagination: {
		    el: '.swiper-pagination1',
		    type: 'bullets',
		    bulletElement: 'button',
		    clickable: true,
		  },
		    navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev',
		    },
		  
		});
	}

	function layerPopOpen(){
		$('.wrap_layerpop2').show().attr('tabindex', -1).focus();
		$('.wrap_layerpop2').removeClass('view');
		$('.wrap_layerpop2').addClass('active');
		$('.layerpop').css('top', (($(window).height() - $('.layerpop').height())/2) + Number($(window).scrollTop()));
	}
	
	
	$(document).on("click",".area_imgView ul li button",function(){
		layerPopOpen();
		openLayerTarget = $(this);
		var imgIndex = $(this).parent().index(); // 0919 클릭한 이미지 index
		var swiper = new Swiper('.swiper-container1', {
			initialSlide: imgIndex, // 0919 클릭한 이미지 index show setting
			zoom: true,
			pagination: {
				el: '.swiper-pagination1',
				bulletElement: 'button',
				clickable: true,
				renderBullet: function (index, className) {
					return '<button type="button" class="' + className + '"><span class="blind">' + (index + 1) + '번째 슬라이드 보기</span></button>';
				}
			},
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			}
		});
	});
	// 사진 더보기 클릭 이벤트
	$(document).on("click",".area_imgView .btn_more",function(){
		layerPopOpen();
		openLayerTarget = $(this);
		var swiper = new Swiper('.swiper-container1', {
			init: true,
			zoom: true,
			pagination: {
				el: '.swiper-pagination1',
				type: 'bullets',
				clickable: true,
				renderBullet: function (index, className) {
					return '<button type="button" class="' + className + '"><span class="blind">' + (index + 1) + '번째 슬라이드 보기</span></button>';
				}
			},
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			}
		});
	});
	
	function mason() {
	    $('.grid').masonry({
	        itemSelector: '.grid-item',
	        columnWidth: '.grid-item'
	      });
	}

	function nevi(kind) {
		if( kind == "kakaomap" ) {
			executeAppKim(conLocationx ,conLocationy);
		} else 	if( kind == 'tmap') {
			executeAppTmap(conLocationx, conLocationy);
		}
	}

	
	function executeAppKim(x, y) {
	    Kakao.Navi.start({
	       name : contitle,
	       x : Number(x),
	       y : Number(y),
	       coordType : 'wgs84'
	    });
	}
	
	function executeAppTmap(x, y) {
	    var url = "http://m.tmap.co.kr/tmap2/mobile/route.jsp?name="+encodeURIComponent(contitle)+"&lon="+x+"&lat="+y;
		var openNewWindow = window.open("about:blank");
		openNewWindow.location.href = url;
		
	}

//	function executeAppTmap(x, y) {
//	    var url = "tmap://route?goalx="+y+"&goaly="+x+"&goalname="+encodeURIComponent(contitle);
//	    location.href = url;
//	}

	function goList(ctype, tagname, rtagid ) {
		
		goTagLogSave(rtagid);
		
	  	setTimeout(function () {
			if( ctype == '15' ) {
				location.href = '/list/fes_list.do?choiceTag='+tagname+'&choiceTagId='+rtagid;
			} else if( ctype == '25' ) {
				location.href = '/list/cs_list.do?choiceTag='+tagname+'&choiceTagId='+rtagid;
			} else {
				location.href = '/list/ms_list.do?choiceTag='+tagname+'&choiceTagId='+rtagid;
			}
	  	}, 200) ;

	}
	
	
	//연관추천 가져오기 auto
	function getContentRecomInfoAuto(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_RECOM_INFO_AUTO_VIEW',
				cotid : cotid,
				areacode : conAreaCode+'',
				sigungucode : conSigunguCode+''
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentRecomInfoAutoView(data,kind);
			},
			complete: function() {
				getContentCourseInfoAuto(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관추천 표시하기 auto
	function goContentRecomInfoAutoView(data,kind) {
		
		var strHtml = '';
		var retemp = '&temp=';
		
		if( data.body.result != undefined ) {
			
			$.each(data.body.result, function (index, items) {
	            strHtml += '<li>';
	            strHtml += '    <a href="../detail/rem_detail.do?cotid='+items.cotId+retemp+'">'+items.title+'</a>';
	            
	            var fareaname = getAreaName(items.areaCode);
	            var fsigunguname = getSigunguName(items.areaCode, items.sigunguCode);

                strHtml += '    <span>'+fareaname+' '+fsigunguname+'</span>';            	

	            strHtml += '</li>';
	            
	            if( index >= 1 ) return false;
			});
			
			$('.list_recom').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.box_recom').show();
			}
			
		}
	}

	//연관코스 가져오기 auto
	function getContentCourseInfoAuto(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_COURSE_INFO_AUTO_VIEW',
				cotid : cotid,
				areacode : conAreaCode+'',
				sigungucode : conSigunguCode+''
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentCourseInfoAutoView(data,kind);
			},
			complete: function() {
				getContentTourInfoAuto(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관코스 표시하기 auto
	function goContentCourseInfoAutoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {
		    	strHtml += '<div class="course_des">';
		    	strHtml += '<a href="../detail/cs_detail.do?cotid='+items.cotId+'"><strong>'+items.title+'</strong>';
		    	strHtml += '<ul>';
		    	
	            var fareaname = getAreaName(items.areaCode);
	            var fsigunguname = getSigunguName(items.areaCode, items.sigunguCode);

		    	strHtml += '<li>지역 : '+fareaname+' '+fsigunguname+'</li>';	    		
	
		    	strHtml += '<li>코스 총거리 : '+items.distanceCL+'</li>';
		    	strHtml += '</ul></a>';
		    	strHtml += '<img src="'+mainimgurl+items.imgPath1+'" alt="" class="img_thumBg">';
		    	strHtml += '</div>';
		    	strHtml += '<ul>';
	
		        var courseList = items.courseList.split("|");  
	
	            for (var i in courseList) {  
	   				strHtml += '<li><span>'+courseList[i]+'</li>';
	   			}	
		    	strHtml += '</ul>';
	
	            if( index >= 0 ) return false;
			});
			
			$('.area_course').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.box_course').show();
			}
			
		}	
	}

	//연관명소 가져오기 auto
	function getContentTourInfoAuto(kind) {
		
		var pdata =
        {
				cmd : 'CONTENT_TOUR_INFO_AUTO_VIEW',
				cotid : cotid,
				areacode : conAreaCode+'',
				sigungucode : conSigunguCode+'',
				locationx : locationx+'',
				locationy : locationy+''
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentTourInfoAutoView(data,kind);
			},
			complete: function() {
				getContentFestivalInfoAuto(kind);
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관명소 표시하기 auto
	function goContentTourInfoAutoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {
	
				var imgpath = '';
				if( items.imgPath1 == undefined || items.imgPath1 == null || items.imgPath1 == 'null' ) {
					imgpath = '/resources/images/common/no_img_01.png';
				} else {
					imgpath = mainimgurl+items.imgPath1;
				}
				
		        strHtml += '<li>';
		       	strHtml += '<a href="/detail/ms_detail.do?cotid='+items.cotId+'">';
		       	strHtml += '    <div class="img_area">';
		       	strHtml += '    	<img src="../resources/images/common/img_dummy.png" alt="">';
		       	strHtml += '		<span class="img" style="background-image:url('+imgpath+');"></span>';
		       	strHtml += '	</div>';
		       	strHtml += '    <strong>'+items.title+'</strong>';
		       	strHtml += '</a>';
		       	strHtml += '</li>';
				
	            if( index >= 1 ) return false;
			});
			
			$('.box_thumRecom ul').html(strHtml);
			if( data.body.result.length > 0 ) {
				$('.box_thumRecom').show();
			}
		}	
	}

	//연관축제 가져오기 auto
	function getContentFestivalInfoAuto(kind) {
		
		if( isNaN(locationx) ) locationx = "0.0";
		if( isNaN(locationy) ) locationy = "0.0";
		
		var pdata =
        {
				cmd : 'CONTENT_FESTIVAL_INFO_AUTO_VIEW',
				cotid : cotid,
				areacode : conAreaCode+'',
				sigungucode : conSigunguCode+'',
				locationx : locationx+'',
				locationy : locationy+''
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentFestivalInfoAutoView(data,kind);
			},
			complete: function() {
				getContentCommentInfo();
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//연관축제 표시하기 auto
	function goContentFestivalInfoAutoView(data,kind) {
		
		var strHtml = '';
    	
		if( data.body.result != undefined ) {
			$.each(data.body.result, function (index, items) {

		        strHtml += '<li>';
		       	strHtml += '<a href="../detail/fes_detail.do?cotid='+items.cotId+'">'+items.title+'</a>';
		       	
	            var fareaname = getAreaName(items.areaCode);
	            var fsigunguname = getSigunguName(items.areaCode, items.sigunguCode);

		       	strHtml += '    <span>'+fareaname+' '+fsigunguname+'</span>';		       		

		       	strHtml += '</li>';

	            if( index >= 1 ) return false;
			});
			
			$('.box_festival ul').html(strHtml);
		}	

		if( data.body.result.length > 0 ) {
			$('.box_festival').show();
		}

		mason();

	}
	