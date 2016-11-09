# OPENVPN

1. 다운로드  
  https://openvpn.net/index.php/open-source/downloads.html  
  Installer (64-bit), Windows Vista and later
  
2. 설치 (서버)
  OpenSSH Utilities 체크  
  OpenVPN RSA Certificates Management Script 체크  

3. 인증서 설정 (서버)
  https://openvpn.net/index.php/open-source/documentation/howto.html#pki  
  run cmd as adminitrator
  
      cd \Program Files\OpenVPN\easy-rsa
      init-config
      vars
      clean-all
      build-ca

      Country Name (2 letter code) [US]:
      State or Province Name (full name) [CA]:
      Locality Name (eg, city) [SanFrancisco]:
      Organization Name (eg, company) [OpenVPN]:
      Organizational Unit Name (eg, section) [changeme]:
      Common Name (eg, your name or your server's hostname) [changeme]: OpenVPN-KOTECH
      Name [changeme]:
      Email Address [mail@host.domain]:
      
      build-key-server server

      Country Name (2 letter code) [US]:
      State or Province Name (full name) [CA]:
      Locality Name (eg, city) [SanFrancisco]:
      Organization Name (eg, company) [OpenVPN]:
      Organizational Unit Name (eg, section) [changeme]:
      Common Name (eg, your name or your server's hostname) [changeme]:server
      Name [changeme]:
      Email Address [mail@host.domain]:
      A challenge password []:
      An optional company name []:
      Sign the certificate? [y/n]:y
      1 out of 1 certificate requests certified, commit? [y/n]y
      Country Name (2 letter code) [US]:

      build-key client1    
      
      State or Province Name (full name) [CA]:
      Locality Name (eg, city) [SanFrancisco]:
      Organization Name (eg, company) [OpenVPN]:
      Organizational Unit Name (eg, section) [changeme]:
      Common Name (eg, your name or your server's hostname) [changeme]:client1
      Name [changeme]:
      Email Address [mail@host.domain]:
      
      
      
      
