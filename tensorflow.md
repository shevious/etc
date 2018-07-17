# install cuda ubuntu

 [NVIDIA CUDA Installation Guide for Linux](https://docs.nvidia.com/cuda/cuda-installation-guide-linux/index.html#abstract)  
 [우분투 16.04에서 CUDA 성공적으로 설치하기](http://www.kwangsiklee.com/ko/2017/07/%EC%9A%B0%EB%B6%84%ED%88%AC-16-04%EC%97%90%EC%84%9C-cuda-%EC%84%B1%EA%B3%B5%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0/)  

```bash
lspci | grep -i nvidia
uname -m && cat /etc/*release
gcc --version
sudo apt-get install linux-headers-$(uname -r)

sudo apt-get remove nvidia* && sudo apt autoremove
sudo apt-get install dkms build-essential linux-headers-generic

# 아래 내용 추가
sudo vi /etc/modprobe.d/blacklist.conf 
```
add lines:
```
blacklist nouveau
blacklist lbm-nouveau
options nouveau modeset=0
alias nouveau off
alias lbm-nouveau off
```
```bash
#필요함?
echo options nouveau modeset=0 | sudo tee -a /etc/modprobe.d/nouveau-kms.conf
#커널 rebuild
sudo update-initramfs -u
#재부팅
sudo reboot
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTI1NTg4MTkxMiwtMTc5MDExMjA5OV19
-->