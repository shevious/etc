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

#그래픽 서비스 종료
sudo service lightdm stop


#graphic driver install
# http://www.nvidia.com/Download/index.aspx?lang=en-us
wget http://us.download.nvidia.com/XFree86/Linux-x86_64/340.32/NVIDIA-Linux-x86_64-340.32.run
sudo ./NVIDIA-Linux-x86_64-340.32.run # 버전은 달라질 수 있다.
```

nomodeset:  
https://askubuntu.com/questions/38780/how-do-i-set-nomodeset-after-ive-already-installed-ubuntu  
http://reachlab-kr.github.io/linux/2015/09/13/Ubuntu-Nvidia-nomodeset.html  


# tensorflow mac

[tensorflow-gpu-macosx](https://github.com/zylo117/tensorflow-gpu-macosx)  
[Tensorflow GPU 1.8 with MacOS 10.13.6](https://egpu.io/forums/mac-setup/tensorflow-gpu-1-8-with-macos-10-13-6/)  
[Tensorflow 1.8 with CUDA on macOS High Sierra 10.13.4](https://gist.github.com/Willian-Zhang/a3bd10da2d8b343875f3862b2a62eb3b)  

#### cuda mac driver

https://www.nvidia.com/object/mac-driver-archive.html  
(installed [CUDA 410.130 driver for MAC](https://www.nvidia.com/object/macosx-cuda-410.130-driver.html) )  
```bash
$ kextstat | grep -i cuda
153  0 0xffffff7f835af000 0x2000 0x2000 com.nvidia.CUDA (1.1.0) E13478CB-B251-3C0A-86E9-A6B56F528FE8 <4 1>
```

#### cuda toolkit 9.1

[cuda-toolkit-archive](https://developer.nvidia.com/cuda-toolkit-archive)  
[cuda-installation-guide-mac-os-x](https://docs.nvidia.com/cuda/archive/9.1/cuda-installation-guide-mac-os-x/index.html)  

Choose which packages you wish to install. The packages are:

-   <font color="lightgray">~~**CUDA Driver**~~: ~~This will install /Library/Frameworks/CUDA.framework and the UNIX-compatibility stub /usr/local/cuda/lib/libcuda.dylib that refers to it.~~ </font>
(Driver는 이미 설치 했으므로 필요없음.)
-   **CUDA Toolkit**: The CUDA Toolkit supplements the CUDA Driver with compilers and additional libraries and header files that are installed into /Developer/NVIDIA/CUDA-9.1 by default. Symlinks are created in /usr/local/cuda/ pointing to their respective files in /Developer/NVIDIA/CUDA-9.1/. Previous installations of the toolkit will be moved to /Developer/NVIDIA/CUDA-#.# to better support side-by-side installations.
-   **CUDA Samples (read-only)**: A read-only copy of the CUDA Samples is installed in /Developer/NVIDIA/CUDA-9.1/samples. Previous installations of the samples will be moved to /Developer/NVIDIA/CUDA-#.#/samples to better support side-by-side installations.

-  Click **Install Local Samples** button during install. 
   => Samples copied to `/Users/username/NVIDIA_CUDA-9.1_Samples`

Set up the required environment variables:

```bash
export PATH=/Developer/NVIDIA/CUDA-9.1/bin${PATH:+:${PATH}}
export DYLD_LIBRARY_PATH=/Developer/NVIDIA/CUDA-9.1/lib\
                         ${DYLD_LIBRARY_PATH:+:${DYLD_LIBRARY_PATH}}

cd ~/NVIDIA_CUDA-9.1_Samples
make -C 0_Simple/vectorAdd
xcode-select: error: tool 'xcodebuild' requires Xcode, but active developer directory '/Library/Developer/CommandLineTools' is a command line tools instance

expr: syntax error

/Developer/NVIDIA/CUDA-9.1/bin/nvcc -ccbin g++ -I../../common/inc  -m64  -Xcompiler -arch -Xcompiler x86_64  -gencode arch=compute_30,code=sm_30 -gencode arch=compute_35,code=sm_35 -gencode arch=compute_37,code=sm_37 -gencode arch=compute_50,code=sm_50 -gencode arch=compute_52,code=sm_52 -gencode arch=compute_60,code=sm_60 -gencode arch=compute_61,code=sm_61 -gencode arch=compute_70,code=sm_70 -gencode arch=compute_70,code=compute_70 -o vectorAdd.o -c vectorAdd.cu

nvcc fatal : The version ('100000') of the host compiler ('Apple clang') is not supported

make: *** [vectorAdd.o] Error 1
```

Error -> Let's try xcode 9.4

#### uninstall cuda 9.1

```bash
cd /Developer/NVIDIA/CUDA-9.1/bin
sudo perl uninstall_cuda_9.1.pl \
    --manifest=.cuda_toolkit_uninstall_manifest_do_not_delete.txt
sudo perl uninstall_cuda_9.1.pl \
    --manifest=.cuda_samples_uninstall_manifest_do_not_delete.txt
```




<!--stackedit_data:
eyJoaXN0b3J5IjpbLTc1NjczMzYwOSwtMTYzMzAyOTE5OSwtMz
gxMDk5NDk3LC01NjEwMzQzOTgsLTQwOTA0NzIyOCw3MDE5ODA0
NDEsNjE2MjkzNjM5LC0yMTA3NjA3ODEwLC0xNjM3MDY2Mjk0LD
EwMDI4MjMzMTAsMjY2MzkyNDc5LC0xNzkwMTEyMDk5XX0=
-->