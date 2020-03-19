function deleteUser(id){
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/delete/"+id,
				  success: function(res) {
					console.log(res);
				}
			  });
		    swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/list";
		    	}
		    });
		  } else {
		    swal("Your imaginary file is safe!");
		  }
		});
}