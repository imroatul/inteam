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
				
				$result=$db->createUser($_POST['emailmember'],
										$_POST['passwordmember'],
										$_POST['namamember']
										);
				if($result == 1){
					$response['error']=false;
					$response['message']="User register sucessfully";
				}elseif($result == 2){
					$response['error']=true;
					$response['message']="Some error occured please try again";
				}elseif($result == 0){
					$response['error']=true;
					$response['message']="It seems you already Registered. Please choose a different email or username";
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