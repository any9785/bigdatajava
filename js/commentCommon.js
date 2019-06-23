	//댓글 가져오기
	function getContentCommentInfo() {

		
		var pdata =
        {
				cmd : 'CONTENT_COMMENT_INFO_VIEW',
				cotid : cotid,
				page : spage+'',
				cnt : scnt+''
        }
    	var obj_st=JSON.stringify(pdata);

		$.ajax({
			url: mainurl+'/call',
			dataType: 'json',
			type: "POST",
			data: obj_st,
			success: function(data) {
				goContentCommentInfoView(data);
			},
			complete: function() {
//				if( uid == null || uid == '' || uid == 'null') {
//					$('#comment').attr('readonly',true);
//				}
				
				$('#comment').click(function(){
					if( uid == null || uid == '' || uid == 'null' || uid == undefined ) {
						layerPopup.layerShow('login');
					}
				});
			},
			error: function(xhr, textStatus, errorThrown) {
			}
		});
	}
	
	
	//댓글 표시하기
	function goContentCommentInfoView(data) {
		
		var strHtml = '';
		
		uid = data.header.id;
		setLogintype(uid);

		stotalCount = data.body.totalCount;
		$('.tit_reply span').html(stotalCount);
		hideMoreBtn();

		if( data.body.result != undefined ) {
			
			$.each(data.body.result, function (index, items) {

				strHtml += '<li>';
				strHtml += '<div class="profile">';
				//strHtml += '<div class="photo photo_def"></div>';<!-- photo_def는 이미지 없을때 추가 -->
				strHtml += '<div class="photo" icid="'+items.cmtId+'"><img src="'+items.url+'" alt="프로필 사진"></div>';
				if( items.snsType == '4') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_naver.png" alt="네이버"></span>';
				} else if( items.snsType == '0') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_facebook.png" alt="페이스북"></span>';
				} else if( items.snsType == '1') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_twitter.png" alt="트위터"></span>';
				} else if( items.snsType == '5') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_kakao.png" alt="카카오"></span>';
				} else if( items.snsType == '6') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_plus.png" alt="구글"></span>';
				} else if( items.snsType == '2') {
					strHtml += '    <span class="ico"><img src="../resources/images/sub/ico_insta2.png" alt="인스타그램"></span>';
				}
				strHtml += '</div>';
				strHtml += '<div class="txt_reply">';
				strHtml += '    <p>'+items.comment+'</p>';
				strHtml += '    <div class="date">';
				strHtml += '        <em class="name">'+items.screenName+'</em>';
				strHtml += '       <span>'+conDateFormat(items.createDate,"yyyyMMdd","-")+'</span>';
				strHtml += '   </div>';
				strHtml += '</div>';

				if( uid == items.snsId ) {
					strHtml += '<button type="button" title="열기" class="btn_view">더보기</button>';
					strHtml += '<div class="pop_subMenu">';
					strHtml += '<ul>';
					strHtml += '    <li class="btn_del"><a href="javascript:" onclick=delComment("'+items.cmtId+'")>삭제</a></li>';
			        strHtml += '</ul>';
			        strHtml += '</div>';

				}
				strHtml += '</li>';
				
			});
			
			$('.list_reply > ul').append(strHtml);

			$.each(data.body.result, function (index, items) {
				$('.list_reply ul li .profile .photo[icid='+items.cmtId+'] img').error(function() {  
					$('.list_reply ul li .profile .photo[icid='+items.cmtId+'] img').remove();
				});
			});
			
			$('.list_reply').show();
			$('.reply_none').hide();
		
		} else {
			$('.reply_none').show();			
		}

	}

	
	//댓글 더보기 클릭시
	$(document).on("click",".btn_center a",function(){
		spage += 1;
		
		hideMoreBtn();
		
		getContentCommentInfo();
	});	

	function hideMoreBtn() {

		if( stotalCount > (scnt*spage) ) {
			$('#commentMore').show();
		} else {
			$('#commentMore').hide();
		}

	}
	

	function delComment(cmtid) {
		if( confirm("댓글을 삭제하시겠습니까 ?") == true) {
			
			var pdata =
	        {
					cmd : 'CONTENT_COMMENTINFO_DELTETE',
					cotid : cotid,
					cmtid : cmtid
	        }
	    	var obj_st=JSON.stringify(pdata);

			$.ajax({
				url: mainurl+'/call',
				dataType: 'json',
				type: "POST",
				data: obj_st,
				success: function(data) {
					
					$('.pop_subMenu').removeClass('on');
					$('.dimmed2').remove();
					
					spage = 1;
					$('.list_reply ul li').remove();
					getContentCommentInfo();
				},
				complete: function() {
				},
				error: function(xhr, textStatus, errorThrown) {
				}
			});
		}
	}
	
	
	
	//댓글 등록
	$(document).on("click",".ContentComment",function(){

		if( loginYn == 'N') {
			layerPopup.layerShow('login');			
		} else {
			if( sloginType == '10' ) {
				layerPopup.layerShow('cosConfirm4');
				return;
			} else {
				saveContentComment();				
			}
		}
	});
	
	//댓글 저장
	function saveContentComment() {
		
		var comment = $('#comment').val();
		
		if( comment != '' ) {
			
			var pdata =
	        {
					cmd : 'CONTENT_COMMENT_SAVE',
					cotid : cotid,	
					comment : chkword(comment)
	        }
	    	var obj_st=JSON.stringify(pdata);

			$.ajax({
				url: mainurl+'/call',
				dataType: 'json',
				type: "POST",
				data: obj_st,
				success: function(data) {
					alert('댓글등록을 완료하였습니다.');	

					spage = 1;
					$('.list_reply ul li').remove();
					getContentCommentInfo();
					
					 $('#comment').val('');
				},
				complete: function() {
				},
				error: function(xhr, textStatus, errorThrown) {
				}
			});
		} else {
			alert('댓글을 입력하세요.');
			return;
		}
		
	}
