<?php
$host = 'localhost'; 
$user = 'ensyscoc_admin; 
$password = 'admin*#402744; 
$database = 'ensyscoc_banglasite';

$outputFile = 'backup_' . date('Y-m-d_H-i-s') . '.sql';

$command = "mysqldump --opt -h $host -u $user -p$password $database > $outputFile";

system($command, $result);

if ($result === 0) {
    header('Content-Description: File Transfer');
    header('Content-Type: application/sql');
    header('Content-Disposition: attachment; filename="' . basename($outputFile) . '"');
    header('Content-Transfer-Encoding: binary');
    header('Expires: 0');
    header('Cache-Control: must-revalidate');
    header('Pragma: public');
    header('Content-Length: ' . filesize($outputFile));

    readfile($outputFile);

    unlink($outputFile);
    exit;
} else {
    echo "Database dump failed!";
}
?>
