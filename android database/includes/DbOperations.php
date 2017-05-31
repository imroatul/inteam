<?php
	class DbOperations{
		private $con;
		function __construct(){
			require_once dirname(__FILE__).'/DbConnect.php';
			$db=new DbConnect();
			$this->con= $db->connect();
		}
		public function createUser($emailmember,$passwordmember,$namamember){
			if($this->isUserExist($emailmember,$namamember)){
				return 0;
			}else{
				$passwordmember=md5($passwordmember);
				$stmt=$this->con->prepare("INSERT INTO `member`(`idMember`, `emailMember`, `passwordMember`, `namaMember`) 
						VALUES (NULL,?,?,?);");
				$stmt->bind_param("sss",$emailmember,$passwordmember,$namamember);
				if($stmt->execute()){
					return 1;
				}else{
					return 2;
				}
			}
		}
		public function userLogin($emailmember,$passwordmember){
			$passwordmember = md5($passwordmember);
			$stmt = $this->con->prepare("SELECT idMember FROM member WHERE emailMember=? AND passwordMember=?");
			$stmt->bind_param("ss", $emailmember,$passwordmember);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
		}
		
		public function getUserByEmail($emailmember){
			$stmt=$this->con->prepare("SELECT * FROM member WHERE emailMember=?");
			$stmt->bind_param("s",$emailmember);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}
		
		private function isUserExist($emailmember,$namamember){
			$stmt = $this->con->prepare("SELECT idMember FROM member WHERE emailMember=? OR namaMember=?");
			$stmt->bind_param("ss", $emailmember,$namamember);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
		}
	}
	?>
			
		