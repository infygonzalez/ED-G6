<?php
session_start();
session_destroy();
setcookie('session_expired', '1', time() + 3600, '/'); 
header("Location: index.php");
exit();
?>