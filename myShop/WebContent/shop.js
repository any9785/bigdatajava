function search() {
       var re = /^[a-zA-Z0-9]{4,12}$/
       var id = document.getElementById("id");
      
       if(!check(re,id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
	   }
	   document.f.submit()
      }

   function check(re, what, message) {
       if(re.test(what.value)) {
           return true;
       }
       alert(message);
       what.value = "";
       what.focus();
       return false;
   }
