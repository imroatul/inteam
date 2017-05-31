<?php
require_once '../includes/DbOperations.php';

$response=array();

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['emailmember']) and isset($_POST['passwordmember'])){
		$db=new DbOperations();
		
		if($db->userLogin($_POST['emailmember'],$_POST['passwordmember']) == true){
			$email = $db->getUserByEmail($_POST['emailmember']);
			$response['error'] = false;
			$response['id']= $email['idMember'];
			$response['emailmember'] = $email['emailMember'];
			$response['passwordmember'] = $email['passwordMember'];
			$response['namamember'] = $email['namaMember'];
		}else{	
			$response['error'] = true;
			$response['message']='Invalid Email or Password';
		}
	}else{
		$response['error']=true;
		$response['message']='Required field are missing';
	}
}
echo json_encode($response);