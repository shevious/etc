## 토토브라우저 시작 폴더
HKEY_CURRENT_USER\SOFTWARE\ToToBrowser\ToToBrowser\setting\LocalPath  

## 드라이브 감추기:
http://www.thewindowsclub.com/show-hide-a-drive-in-windows  
https://www.tenforums.com/drivers-hardware/15278-how-hide-drive-explorer-without-removing-drive-letter.html  

## 2018-05-12 wol from shutdown
강제 전원 오프시 wol동작, 맥에서 꺼도 wol 동작, windows에서 종료하면 wol fail.  
이유:  
https://support.microsoft.com/en-us/help/2776718/wake-on-lan-wol-behavior-in-windows-8-windows-8-1-and-windows-10  
해결:    
https://answers.microsoft.com/en-us/windows/forum/windows_10-hardware-winpc/windows-10-turns-off-network-adapter-wol-not/1c26f5dc-ab8e-4dff-b0ee-050a35445812  
맨 아래에 드라이버 관련 언급 있음.  
최신 intel i217-v 드라이버 설치 => s5상태에서 wol 체크 옵션 생김.  
=> wol 정상  

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIyMTY1OTQxNF19
-->