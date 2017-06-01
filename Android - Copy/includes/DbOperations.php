<?php
	class DbOperations{
		private $con;
		function __construct(){
			require_once dirname(__FILE__).'/DbConnect.php';
			$db=new DbConnect();
			$this->con= $db->connect();
		}
		function createUser($emailmember,$passwordmember,$namaMember){
			$passwordmember=md5($passwordmember);
			$stmt=$this->con->prepare("INSERT INTO `member`(`idMember`, `emailMember`, `passwordMember`, `namaMember`) VALUES (NULL,?,?,?);");
			$stmt->bind_param("sss",$emailmember,$passwordmember,$namaMember);
			if($stmt->execute()){
				return true;
			}else{
				return false;
			}
		}
	}
	?>
			
		