
    function emailCheck(){
        if($("#email").val()==""){
            $("#email").addClass('is-invalid');
            return false;
        }else{
            var regMail     =   /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;
            if(regMail.test($("#email").val()) == false){
                $("#email").addClass('is-invalid');
                return false;
            }else{
                $("#email").removeClass('is-invalid');
                
            }
 
        }
    }
    function validation(){
        if($("#firstname, #lastname, #username, #phone, #address, #password, #cpassword").val()==""){
            $("#firstname, #lastname, #username, #phone, #address, #password, #cpassword").addClass('is-invalid');
            return false;
        }else{
            $("#firstname, #lastname, #username, #phone, #address, #password, #cpassword").removeClass('is-invalid');
        }
         
        if($("#password").val()!=$("#cpassword").val()){
            $("#cpassword").addClass('is-invalid');
            $("#cp").html('<span class="text-danger">Password and confirm password not matched!</span>');
            return false;
        }
    }
    $(document).ready(function(e) {
    	$("#firstname").on("keyup",function(){
            if($("#firstname").val()==""){
                $("#firstname").addClass('is-invalid');
                return false;
            }else{
                $("#firstname").removeClass('is-invalid');
            }
        });
    	$("#lastname").on("keyup",function(){
            if($("#lastname").val()==""){
                $("#lastname").addClass('is-invalid');
                return false;
            }else{
                $("#lastname").removeClass('is-invalid');
            }
        });
        $("#username").on("keyup",function(){
            if($("#username").val()==""){
                $("#username").addClass('is-invalid');
                return false;
            }else{
                $("#username").removeClass('is-invalid');
            }
        });
        $("#phone").on("keyup",function(){
            if($("#phone").val()==""){
                $("#phone").addClass('is-invalid');
                return false;
            }else{
                $("#phone").removeClass('is-invalid');
            }
        });
        $("#password").on("keyup",function(){
            if($("#password").val()==""){
                $("#password").addClass('is-invalid');
                return false;
            }else{
                $("#password").removeClass('is-invalid');
            }
        });
        $("#cpassword").on("keyup",function(){
            if($("#cpassword").val()==""){
                $("#cpassword").addClass('is-invalid');
                return false;
            }else{
                $("#cpassword").removeClass('is-invalid');
            }
        });
    });
