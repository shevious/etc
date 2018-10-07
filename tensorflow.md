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

## High Sierra 10.13.6




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

#### cuda mac driver
cuda control panel 에서 update 필요하다고 경고함.


https://www.nvidia.com/object/mac-driver-archive.html  

[NVIDIA CUDA 387.178 FOR MACOS RELEASE](https://www.nvidia.com/object/macosx-cuda-387.178-driver.html)  
~~([CUDA 410.130 driver for MAC](https://www.nvidia.com/object/macosx-cuda-410.130-driver.html) )~~  

```bash
$ kextstat | grep -i cuda
154  0 0xffffff7f83306000 0x2000 0x2000 com.nvidia.CUDA (1.1.0) 4329B052-6C8A-3900-8E83-744487AEDEF1 <4 1>
```


Set up the required environment variables:

```bash
export PATH=/Developer/NVIDIA/CUDA-9.1/bin${PATH:+:${PATH}}
export DYLD_LIBRARY_PATH=/Developer/NVIDIA/CUDA-9.1/lib\
                         ${DYLD_LIBRARY_PATH:+:${DYLD_LIBRARY_PATH}}
$ xcode-select -p
/Applications/Xcode_9.2.app/Contents/Developer
$ make -C 0_Simple/vectorAdd
/Developer/NVIDIA/CUDA-9.1/bin/nvcc -ccbin clang++ -I../../common/inc  -m64  -Xcompiler -arch -Xcompiler x86_64  -gencode arch=compute_30,code=sm_30 -gencode arch=compute_35,code=sm_35 -gencode arch=compute_37,code=sm_37 -gencode arch=compute_50,code=sm_50 -gencode arch=compute_52,code=sm_52 -gencode arch=compute_60,code=sm_60 -gencode arch=compute_61,code=sm_61 -gencode arch=compute_70,code=sm_70 -gencode arch=compute_70,code=compute_70 -o vectorAdd.o -c vectorAdd.cu
/Developer/NVIDIA/CUDA-9.1/bin/nvcc -ccbin clang++ -m64  -Xcompiler -arch -Xcompiler x86_64  -Xlinker -rpath -Xlinker /Developer/NVIDIA/CUDA-9.1/lib  -gencode arch=compute_30,code=sm_30 -gencode arch=compute_35,code=sm_35 -gencode arch=compute_37,code=sm_37 -gencode arch=compute_50,code=sm_50 -gencode arch=compute_52,code=sm_52 -gencode arch=compute_60,code=sm_60 -gencode arch=compute_61,code=sm_61 -gencode arch=compute_70,code=sm_70 -gencode arch=compute_70,code=compute_70 -o vectorAdd vectorAdd.o
mkdir -p ../../bin/x86_64/darwin/release
cp vectorAdd ../../bin/x86_64/darwin/release

$ bin/x86_64/darwin/release/vectorAdd
[Vector addition of 50000 elements]
Copy input data from the host memory to the CUDA device
CUDA kernel launch with 196 blocks of 256 threads
Copy output data from the CUDA device to the host memory
Test PASSED
Done
```
Succcess with no warnings.


#### mojave error log
```bash
cd ~/NVIDIA_CUDA-9.1_Samples
make -C 0_Simple/vectorAdd
xcode-select: error: tool 'xcodebuild' requires Xcode, but active developer directory '/Library/Developer/CommandLineTools' is a command line tools instance

expr: syntax error

/Developer/NVIDIA/CUDA-9.1/bin/nvcc -ccbin g++ -I../../common/inc  -m64  -Xcompiler -arch -Xcompiler x86_64  -gencode arch=compute_30,code=sm_30 -gencode arch=compute_35,code=sm_35 -gencode arch=compute_37,code=sm_37 -gencode arch=compute_50,code=sm_50 -gencode arch=compute_52,code=sm_52 -gencode arch=compute_60,code=sm_60 -gencode arch=compute_61,code=sm_61 -gencode arch=compute_70,code=sm_70 -gencode arch=compute_70,code=compute_70 -o vectorAdd.o -c vectorAdd.cu

nvcc fatal : The version ('100000') of the host compiler ('Apple clang') is not supported

make: *** [vectorAdd.o] Error 1
```

Error -> Let's try xcode 9.4

#### uninstall cuda 9.1 (when needed)

```bash
cd /Developer/NVIDIA/CUDA-9.1/bin
sudo perl uninstall_cuda_9.1.pl \
    --manifest=.cuda_toolkit_uninstall_manifest_do_not_delete.txt
sudo perl uninstall_cuda_9.1.pl \
    --manifest=.cuda_samples_uninstall_manifest_do_not_delete.txt
cd /usr/local/cuda
sudo perl uninstall_cuda_drv.pl \
    --manifest=.cuda_driver_uninstall_manifest_do_not_delete.txt
```

#### xcode 9.2 for cuda tookit 9.1

```bash
curl -H "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8" \
-H "Accept-Encoding: gzip, deflate, br" \
-H "Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7" \
-H "Connection: keep-alive" \
-H "Cookie: dssf=1; s_fid=7B2474B1704AB4C0-233AFB5D00390B14; s_vi=[CS]v1|2DBE072F052E2A85-40000C34600001C3[CE]; xp_ci=3z2GpXU1zDljz4Qgz9cMzgOtVEJAB; dslang=US-EN; acn01=b8VHTYf01/49wP7Ufmu4lK/bbmrqgjbJW6MADxHCNakuIQ==; myacinfo=DAWTKNV2e2b1b4bfddbc35a9c70fe3baa45c1dfa980e80b149c3befeb75420f4f36c42d2ebb6762ec4d701b23dd254f86408e2047cf5398c7e9a9952551d85580a15cc7c47cd83b380d73ed08d8a9e82303a44f48c14e61a295babcc0caf3430271e4e7b65cd1d16fb741722b93fd992b0ef3d00370aa8988959a6d9f811115b52968decf3203de54d1f46bf592baa4d1f648317e4516aac79d9672f29c5c9c422d3b7bbca7183336d3d63e1787a924c749923cf007a57d069fde8ff8186609a1cd4ea765f3adc14f20f387ffd44f37a8eb61325b06f02204ade7f45c14cec1c7bae2a448727ef62430e2467cef1a955c4ad36bb35653535306537666138663161356131326263333530313263333835666231396363383030326339MVRYV2; acack=DAWTKNV2e2b1b4bfddbc35a9c70fe3baa45c1dfa980e80b149c3befeb75420f4f36c42d2ebb6762ec4d701b23dd254f86408e2047cf5398c7e9a9952551d85580a15cc7c47cd83b380d73ed08d8a9e82303a44f48c14e61a295babcc0caf3430271e4e7b65cd1d16fb741722b93fd992b0ef3d00370aa8988959a6d9f811115b52968decf3203de54d1f46bf592baa4d1f648317e4516aac79d9672f29c5c9c422d3b7bbca7183336d3d63e1787a924c749923cf007a57d069fde8ff8186609a1cd4ea765f3adc14f20f387ffd44f37a8eb61325b06f02204ade7f45c14cec1c7bae2a448727ef62430e2467cef1a955c4ad36bb35653535306537666138663161356131326263333530313263333835666231396363383030326339MVRYV2; DSESSIONID=bc9e08b7f9edc6764b9733a4e0593dab07cec42c8a1f540ddda3f4e4529e5c3e; s_vnum_n2_us=4|2; s_pathLength=developer%3D1%2C; s_cc=true; ADCDownloadAuth=Y6bz8ZzW6Kwh%2BIFwVG69G8j4IKPMrDPfzM9VoR0u9zN7cG3i6rwhYezGF%2BcvbDnweAkiNeWm1ghE%0D%0ARUHKPRDfoo7B5qEQW9LvATUfZY4ZzApBzhyZF4QtL3mCNBX9hjfEScm4gBHr2vYQkIOstqi3Pr%2F%2F%0D%0AW0sHZHiQu5cOuIoOvxGSGc%2Fy%0D%0A" \
-H "Host: download.developer.apple.com" \
-H "Referer: https://developer.apple.com/download/more/" \
-H "Upgrade-Insecure-Requests: 1" \
-H "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36" \
-LO https://download.developer.apple.com/Developer_Tools/Xcode_9.2/Xcode_9.2.xip
```
copy `xcode_9.2` to `/Applications`
```bash
$ xcode-select -p
/Library/Developer/CommandLineTools
$ sudo xcode-select -s /Applications/Xcode_9.2.app
$ xcode-select -p
/Applications/Xcode_9.2.app/Contents/Develope
```

compile ok -> execution hang.
(maybe it's mojave problem.)

#### remove cuda from Mojave (just for reference)

https://www.travelertechie.com/2018/10/how-to-uninstall-cuda-drivers-from-macos.html  

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE3NDYzMjA0NDgsMTIwMjE4MDg5MiwyMz
Q4MDI4MjAsLTM0OTMwNTg2OSwtOTMxOTA5NzAwLC05NTkzMTM3
MDIsNzM0OTAzNDgyLC00OTY2Njg5MzAsOTU3NzM5NzM2LC0xMz
g5MDMzNjAzLDg0MjQxMzg1NywtMTYzMzAyOTE5OSwtMzgxMDk5
NDk3LC01NjEwMzQzOTgsLTQwOTA0NzIyOCw3MDE5ODA0NDEsNj
E2MjkzNjM5LC0yMTA3NjA3ODEwLC0xNjM3MDY2Mjk0LDEwMDI4
MjMzMTBdfQ==
-->