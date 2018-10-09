# tensorflow mac

[tensorflow-gpu-macosx](https://github.com/zylo117/tensorflow-gpu-macosx)  

[Tensorflow 1.8 with CUDA on macOS High Sierra 10.13.4](https://gist.github.com/Willian-Zhang/a3bd10da2d8b343875f3862b2a62eb3b)  

[74th](https://gist.github.com/74th)/**[tensorflow_1.8.0_macos_nvidia.patch](https://gist.github.com/74th/31eacbbac6351649caa417b19231f09e)**  

[Tensorflow GPU 1.8 with MacOS 10.13.6](https://egpu.io/forums/mac-setup/tensorflow-gpu-1-8-with-macos-10-13-6/)  
(It is compiled to GPU cap 6.1)

[MacでGPU(cuda)が使えるtensorflowをビルドする](https://qiita.com/74th/items/fc6ebb684c23f3655e7c)  

## High Sierra 10.13.6

#### xcode 9.2
xcode 9.2 and command line tools for 10.13 xcode 9.2

#### cuda toolkit 9.1

[cuda-toolkit-archive](https://developer.nvidia.com/cuda-toolkit-archive)  
[cuda-installation-guide-mac-os-x](https://docs.nvidia.com/cuda/archive/9.1/cuda-installation-guide-mac-os-x/index.html)  

Choose which packages you wish to install. The packages are:

-   **CUDA Driver**: This will install /Library/Frameworks/CUDA.framework and the UNIX-compatibility stub /usr/local/cuda/lib/libcuda.dylib that refers to it.

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
/Library/Developer/CommandLineTools

#sudo xcode-select -s /Applications/Xcode_9.2.app
#xcode-select -p /Applications/Xcode_9.2.app/Contents/Developer
# install command line tools for xcode9.2 & macos 10.13

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

```bash
$ make -C 1_Utilities/deviceQuery
$ bin/x86_64/darwin/release/deviceQuery
bin/x86_64/darwin/release/deviceQuery Starting...

CUDA Device Query (Runtime API) version (CUDART static linking)

Detected 1 CUDA Capable device(s)

Device 0: "GeForce GTX 750 Ti"
CUDA Driver Version / Runtime Version  9.1 / 9.1
CUDA Capability Major/Minor version number:  5.0
Total amount of global memory: 2048 MBytes (2147155968 bytes)
( 5) Multiprocessors, (128) CUDA Cores/MP: 640 CUDA Cores
GPU Max Clock rate:  1110 MHz (1.11 GHz)
Memory Clock rate: 2700 Mhz
Memory Bus Width:  128-bit
L2 Cache Size: 2097152 bytes
Maximum Texture Dimension Size (x,y,z) 1D=(65536), 2D=(65536, 65536), 3D=(4096, 4096, 4096)
Maximum Layered 1D Texture Size, (num) layers  1D=(16384), 2048 layers
Maximum Layered 2D Texture Size, (num) layers  2D=(16384, 16384), 2048 layers
Total amount of constant memory: 65536 bytes
Total amount of shared memory per block: 49152 bytes
Total number of registers available per block: 65536
Warp size: 32
Maximum number of threads per multiprocessor:  2048
Maximum number of threads per block: 1024
Max dimension size of a thread block (x,y,z): (1024, 1024, 64)
Max dimension size of a grid size  (x,y,z): (2147483647, 65535, 65535)
Maximum memory pitch:  2147483647 bytes
Texture alignment: 512 bytes
Concurrent copy and kernel execution:  Yes with 1 copy engine(s)
Run time limit on kernels: Yes
Integrated GPU sharing Host Memory:  No
Support host page-locked memory mapping: Yes
Alignment requirement for Surfaces:  Yes
Device has ECC support:  Disabled
Device supports Unified Addressing (UVA):  Yes
Supports Cooperative Kernel Launch:  No
Supports MultiDevice Co-op Kernel Launch:  No
Device PCI Domain ID / Bus ID / location ID: 0 / 1 / 0
Compute Mode:
< Default (multiple host threads can use ::cudaSetDevice() with device simultaneously) >

deviceQuery, CUDA Driver = CUDART, CUDA Driver Version = 9.1, CUDA Runtime Version = 9.1, NumDevs = 1
Result = PASS
```

#### cuDNN

https://developer.nvidia.com/rdp/cudnn-archive  
https://docs.nvidia.com/deeplearning/sdk/cudnn-archived/index.html  

```bash
mkdir ~/cudnn
cd ~/cudnn
tar -xvzf ~/Downloads/cudnn-9.1-osx-x64-v7-ga.tgz
sudo cp cuda/include/cudnn.h /usr/local/cuda/include
sudo cp cuda/lib/libcudnn* /usr/local/cuda/lib
sudo chmod a+r /usr/local/cuda/include/cudnn.h /usr/local/cuda/lib/libcudnn*
export  DYLD_LIBRARY_PATH=/usr/local/cuda/lib:$DYLD_LIBRARY_PATH
```

#### install homebrew

https://brew.sh/index_ko

```bash
brew install coreutils
brew install llvm
brew install cliutils/apple/libomp
```
```bash
cd ~/Downloads
chmod +x bazel-0.14.1-installer-darwin-x86_64.sh
./bazel-0.14.1-installer-darwin-x86_64.sh --user
Bazel installer
---------------

Bazel is bundled with software licensed under the GPLv2 with Classpath exception.
You can find the sources next to the installer on our release page:
   https://github.com/bazelbuild/bazel/releases

# Release 0.14.1 (2018-06-08)

Baseline: 5c3f5c9be7fa40d4fb3c35756891fab8483ca406

Cherry picks:
   + f96f037f8f77335dc444844abcc31a372a3e1849:
     Windows, Java launcher: Support jar files under different drives
   + ff8162d01409db34893de98bd840a51c5f13e257:
     sh_configure.bzl: FreeBSD is also a known platform
   + 7092ed324137f03fcd34856bdb0595a1bdec3069:
     Remove unneeded exec_compatible_with from local_sh_toolchain
   + 57bc201346e61c62a921c1cbf32ad24f185c10c9:
     Do not autodetect C++ toolchain when
     BAZEL_DO_NOT_DETECT_CPP_TOOLCHAIN=1 is present
   + 35a78c09cf2fbfc3de9c124d2142e3d72aac4348:
     remote: recursively delete incomplete downloaded output
     directory.
   + 3c9cd82b847f3ece8ec04b2029bd5e8ad0eb7502:
     distfile: pack the archives needed later in the build
   + 27487c77387e457df18be3b6833697096d074eab:
     Slightly refactor SpawnAction to improve env handling
   + 1b333a2c37add9d04fe5bc5258ee4f73c93115e2:
     Fix Cpp{Compile,Link}Action environment and cache key computation
   + 3da8929963e9c70dff5d8859d6e988e6e7f4f9d7:
     Make SymlinkTreeAction properly use the configuration's
     environment
   + eca7b81cf8cc51e1fe56e5ed7d4ad5cd1668a17a:
     Add a missing dependency from checker framework dataflow to
     javacutils
   + 10a4de954c2061258d8222961fc3bd39516db49d:
     Release 0.14.0 (2018-06-01)
   + 4b80f2455e7e49a95f3a4c9102a67a57dad52207:
     Add option to enable Docker sandboxing.
   + 6b1635279e8b33dc1ac505ac81825e38f8797a14:
     Allow disabling the simple blob caches via CLI flag overrides.

Bug fix for [#5336](https://github.com/bazelbuild/bazel/issues/5336)
Bug fix fot [#5308](https://github.com/bazelbuild/bazel/issues/5308)

## Build informations
   - [Commit](https://github.com/bazelbuild/bazel/commit/26abd1d0ce)
Uncompressing......Extracting Bazel installation...
.

Bazel is now installed!

Make sure you have "/Users/shevious/bin" in your path. You can also activate bash
completion by adding the following line to your ~/.bash_profile:
  source /Users/shevious/.bazel/bin/bazel-complete.bash

See http://bazel.build/docs/getting-started.html to start a new project!

export PATH=$PATH:$HOME/bin
```
```bash
brew install python
pip3 install virtualenv
virtualenv venv
source venv/bin/activate
```

#### ./configure
```
(venv) sheviousui-iMac:~ shevious$ cd tensorflow-gpu-macosx/
(venv) sheviousui-iMac:tensorflow-gpu-macosx shevious$ ./configure 
Unable to find any JVMs matching version "1.7+".
No Java runtime present, try --request to install.
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.protobuf.UnsafeUtil (file:/private/var/tmp/_bazel_shevious/install/ab3f5a92193ce7d9503f32b8ce350934/_embedded_binaries/A-server.jar) to field java.lang.String.value
WARNING: Please consider reporting this to the maintainers of com.google.protobuf.UnsafeUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
WARNING: --batch mode is deprecated. Please instead explicitly shut down your Bazel server using the command "bazel shutdown".
You have bazel 0.17.2 installed.
Please specify the location of python. [Default is /Users/shevious/venv/bin/python]: 


Traceback (most recent call last):
  File "<string>", line 1, in <module>
AttributeError: module 'site' has no attribute 'getsitepackages'
Found possible Python library paths:
  /Users/shevious/venv/lib/python3.7/site-packages
Please input the desired Python library path to use.  Default is [/Users/shevious/venv/lib/python3.7/site-packages]

Do you wish to build TensorFlow with Google Cloud Platform support? [Y/n]: n
No Google Cloud Platform support will be enabled for TensorFlow.

Do you wish to build TensorFlow with Hadoop File System support? [Y/n]: n
No Hadoop File System support will be enabled for TensorFlow.

Do you wish to build TensorFlow with Amazon AWS Platform support? [Y/n]: n
No Amazon AWS Platform support will be enabled for TensorFlow.

Do you wish to build TensorFlow with Apache Kafka Platform support? [Y/n]: n
No Apache Kafka Platform support will be enabled for TensorFlow.

Do you wish to build TensorFlow with XLA JIT support? [y/N]: n
No XLA JIT support will be enabled for TensorFlow.

Do you wish to build TensorFlow with GDR support? [y/N]: n
No GDR support will be enabled for TensorFlow.

Do you wish to build TensorFlow with VERBS support? [y/N]: n
No VERBS support will be enabled for TensorFlow.

Do you wish to build TensorFlow with OpenCL SYCL support? [y/N]: n
No OpenCL SYCL support will be enabled for TensorFlow.

Do you wish to build TensorFlow with CUDA support? [y/N]: y
CUDA support will be enabled for TensorFlow.

Please specify the CUDA SDK version you want to use. [Leave empty to default to CUDA 9.0]: 9.1


Please specify the location where CUDA 9.1 toolkit is installed. Refer to README.md for more details. [Default is /usr/local/cuda]: 


Please specify the cuDNN version you want to use. [Leave empty to default to cuDNN 7.0]: 


Please specify the location where cuDNN 7 library is installed. Refer to README.md for more details. [Default is /usr/local/cuda]:


Please specify a list of comma-separated Cuda compute capabilities you want to build with.
You can find the compute capability of your device at: https://developer.nvidia.com/cuda-gpus.
Please note that each additional compute capability significantly increases your build time and binary size. [Default is: 3.5,7.0]5.0


Do you want to use clang as CUDA compiler? [y/N]: n
nvcc will be used as CUDA compiler.

Please specify which gcc should be used by nvcc as the host compiler. [Default is /usr/bin/gcc]: 


Do you wish to build TensorFlow with MPI support? [y/N]: n
No MPI support will be enabled for TensorFlow.

Please specify optimization flags to use during compilation when bazel option "--config=opt" is specified [Default is -march=native]: 


Would you like to interactively configure ./WORKSPACE for Android builds? [y/N]: n
Not configuring the WORKSPACE for Android builds.

Preconfigured Bazel build configs. You can use any of the below by adding "--config=<>" to your build command. See tools/bazel.rc for more details.
        --config=mkl            # Build with MKL support.
        --config=monolithic     # Config for mostly static monolithic build.
Configuration finished
```
```bash
bazel clean --expunge
bazel build --config=cuda --config=opt --cxxopt="-D_GLIBCXX_USE_CXX11_ABI=0" --action_env PATH --action_env LD_LIBRARY_PATH --action_env DYLD_LIBRARY_PATH //tensorflow/tools/pip_package:build_pip_package
```

try to build:
```
# build failed
$ bazel build --config=cuda --config=opt --cxxopt="-D_GLIBCXX_USE_CXX11_ABI=0" --action_env PATH --action_env LD_LIBRARY_PATH --action_env DYLD_LIBRARY_PATH //tensorflow/tools/pip_package:build_pip_package
Unable to find any JVMs matching version "1.7+".
No Java runtime present, try --request to install.
WARNING: The following configs were expanded more than once: [cuda]. For repeatable flags, repeats are counted twice and may lead to unexpected behavior.
ERROR: /Users/shevious/tensorflow-gpu-macosx/tensorflow/tools/pip_package/BUILD:166:1: error loading package 'tensorflow': Encountered error while reading extension file 'protobuf.bzl': no such package '@protobuf_archive//': java.io.IOException: Error downloading [https://mirror.bazel.build/github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz, https://github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz] to /private/var/tmp/_bazel_shevious/70839c20b974647953bdf89774ca3e3d/external/protobuf_archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz: All mirrors are down: [GET returned 403 Forbidden, GET returned 404 Not Found] and referenced by '//tensorflow/tools/pip_package:build_pip_package'
ERROR: /Users/shevious/tensorflow-gpu-macosx/tensorflow/tools/pip_package/BUILD:166:1: error loading package 'tensorflow': Encountered error while reading extension file 'protobuf.bzl': no such package '@protobuf_archive//': java.io.IOException: Error downloading [https://mirror.bazel.build/github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz, https://github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz] to /private/var/tmp/_bazel_shevious/70839c20b974647953bdf89774ca3e3d/external/protobuf_archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz: All mirrors are down: [GET returned 403 Forbidden, GET returned 404 Not Found] and referenced by '//tensorflow/tools/pip_package:build_pip_package'
ERROR: Analysis of target '//tensorflow/tools/pip_package:build_pip_package' failed; build aborted: error loading package 'tensorflow': Encountered error while reading extension file 'protobuf.bzl': no such package '@protobuf_archive//': java.io.IOException: Error downloading [https://mirror.bazel.build/github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz, https://github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz] to /private/var/tmp/_bazel_shevious/70839c20b974647953bdf89774ca3e3d/external/protobuf_archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz: All mirrors are down: [GET returned 403 Forbidden, GET returned 404 Not Found]
INFO: Elapsed time: 19.428s
INFO: 0 processes.
FAILED: Build did NOT complete successfully (0 packages loaded)
    currently loading: tensorflow
```
build fail: no url: 
`https://github.com/dtrebbien/protobuf/archive/50f552646ba1de79e07562b41f3999fe036b4fd0.tar.gz`
=> fetch from official tensorflow v1.8.0 tag to `tensorflow/workspace.bzl`
=> compile error because it should be patched. => 
[Build Error Windows, No results found for more than one instance of overloaded function](https://github.com/tensorflow/tensorflow/issues/17067#issuecomment-366496974)  
```properties
   tf_http_archive(
       name = "protobuf_archive",
       urls = [
-          "https://mirror.bazel.build/github.com/google/protobuf/archive/396336eb961b75f03b25824fe86cf6490fb75e3a.tar.gz",
-          "https://github.com/google/protobuf/archive/396336eb961b75f03b25824fe86cf6490fb75e3a.tar.gz",
+          "https://mirror.bazel.build/github.com/dinever/protobuf/archive/188578878eff18c2148baba0e116d87ce8f49410.tar.gz",
+          "https://github.com/dinever/protobuf/archive/188578878eff18c2148baba0e116d87ce8f49410.tar.gz",
       ],
-      sha256 = "846d907acf472ae233ec0882ef3a2d24edbbe834b80c305e867ac65a1f2c59e3",
-      strip_prefix = "protobuf-396336eb961b75f03b25824fe86cf6490fb75e3a",
+      sha256 = "7a1d96ccdf7131535828cad737a76fd65ed766e9511e468d0daa3cc4f3db5175",
+      strip_prefix = "protobuf-188578878eff18c2148baba0e116d87ce8f49410",
   )
```
build again    
no Java VM    
install [jdk-8u181-macosx-x64.dmg](http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-macosx-x64.dmg)  

```bash
sudo xcode-select -s /Applications/Xcode_9.2.app
pip install numpy
```
error=> which is related to python 3.7 => go back to 3.6
```bash
brew uninstall python
brew install https://raw.githubusercontent.com/Homebrew/homebrew-core/f2a764ef944b1080be64bd88dca9a1d80130c558/Formula/python.rb
rm -rf ~/venv
virtualenv venv
. venv/bin/activate
pip install numpy
./configure again (python library path changed)
``` 

link error => https://github.com/tensorflow/tensorflow/issues/22527

try to using bazel 16
```
ld: warning: cannot export hidden symbol std::__1::__vector_base<tensorflow::graph_transforms::OpTypePattern, std::__1::allocator<tensorflow::graph_transforms::OpTypePattern> >::__destruct_at_end(tensorflow::graph_transforms::OpTypePattern*) from bazel-out/darwin-opt/bin/tensorflow/tools/graph_transforms/libtransforms_lib.pic.lo(remove_nodes.pic.o)
Target //tensorflow/tools/pip_package:build_pip_package up-to-date:
  bazel-bin/tensorflow/tools/pip_package/build_pip_package
INFO: Elapsed time: 10703.440s, Critical Path: 353.72s
INFO: 8634 processes: 8634 local.
INFO: Build completed successfully, 9160 total actions
```
total 9160 => success


#### to check
https://gist.github.com/Willian-Zhang/088e017774536880bd425178b46b8c17  

https://github.com/tensorflow/tensorflow/issues/19304    
https://stackoverflow.com/questions/49860329/tf-1-7-not-found-tf-gpu-device-with-id-0-was-not-registered  

# Mojave with no nvidia web drive
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
eyJoaXN0b3J5IjpbLTEwOTU1MDk5MzksMTQ0MzM4Mjk0NiwtMj
Y1MTA2MTgyLDIxMjgzNjQzOSwtMjA0NjE2MDU2MCwxMTQ0Njgx
OCwtNzU0MDU4NDA4LC0xOTE1MjQxMjU5LC0yMDI3MjgwODgwLD
MyMDc0MjQsLTQ5NDc5MzkzNywyMTA4OTg0NDQ1LDE4MTU5Njk1
NTYsLTExOTc4MDQ4MDMsLTEzOTA0Mzg1MzgsMjA0OTM4ODgwMC
wtMTAyMTgxMDEyOSwtMTU4NzE2NTQzMiwxNDQxODQ1NjYsMTQ0
MDg0Mjk5MV19
-->