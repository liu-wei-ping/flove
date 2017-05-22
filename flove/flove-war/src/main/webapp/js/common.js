//(function() {
	ajaxFun=function(url, data, callback){
	    var type =( data==undefined||data == null) ? "GET" : "POST";
	    $.ajax({
	        url : url,
	        data : data,
	        type : type,
	        dataType : 'json',
	        success : function(req) {
	            if(typeof(callback)!=="function"){
	                alert("SUCCESS");
	            }else{
	             callback(req);
	            }
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
	}
//})