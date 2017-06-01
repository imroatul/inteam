<?php
require_once '../includes/DbOperations.php';
$response=array();
if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
			isset($_POST['emailmember']) and
				isset($_POST['passwordmember'])and
				isset($_POST['namamember']) )
				{
				$db=new DbOperations();
				if($db->createUser($_POST['emailmember'],$_POST['passwordmember'],$_POST['namamember'])){
					$response['error']=false;
					$response['message']="User register sucessfully";
				}else{
					$response['error']=true;
					$response['message']="Some error occured please try again";
				}
			}else{
				$response['error']=true;
				$response['message']='Required field are missing';
			}
}else{
	$response['error']=true;
	$response['message']='Invalid Request';
}
echo json_encode($response);