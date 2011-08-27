inherit image

DEPENDS = " task-base task-sdk-native gst-plugins-base gst-plugins-good gst-plugins-bad gst-plugins-ugly "

ANGSTROM_EXTRA_INSTALL ?= ""

# DISTRO_SSH_DAEMON ?= "openssh"
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
            util-linux-ng-mount util-linux-ng-umount \
            ${DISTRO_SSH_DAEMON} \
            ${ANGSTROM_EXTRA_INSTALL} \
            angstrom-version \
           "
IMAGE_LINGUAS = ""

# Kernel related modules and staff
IMAGE_INSTALL += " rt73-firmware kernel-module-rt73usb kernel-module-rt2x00lib kernel-module-rt2x00usb kernel-module-uvcvideo "
IMAGE_INSTALL += " kernel-module-usbserial kernel-module-pl2303 "
IMAGE_INSTALL += " ti-codecs-omap3530-server ti-cmem-module ti-dsplink-module ti-lpm-module ti-sdma-module "
IMAGE_INSTALL += " kernel-module-pwc setpwc kernel-module-ar9170usb easycapdc60 "
# Kernel > .35, the easycap is part of the mainline kernel
# IMAGE_INSTALL += " kernel-module-pwc setpwc kernel-module-ar9170usb kernel-module-easycap kernel-module-bridge kernel-module-bridgedriver "

# GStreamer related installs
IMAGE_INSTALL += " gstreamer gst-plugins-base gst-plugins-base-apps gst-plugin-app gst-plugin-ffmpegcolorspace "
IMAGE_INSTALL += " gst-plugin-video4linux2 gst-plugin-rtp gst-plugin-videomixer gst-plugin-videoscale gst-plugin-videobox "
#IMAGE_INSTALL += " gst-dsp "
IMAGE_INSTALL += " gstreamer-ti "

# Several usefull utilities
IMAGE_INSTALL += " mtd-utils devmem2 i2c-tools wireless-tools wpa-supplicant opencv-apps avahi avahi-daemon avahi-dnsconfd "
IMAGE_INSTALL += " gpsd ntp xenomai "

# Development environment
IMAGE_INSTALL += " task-sdk-native git cmake slice2cppe icee-slice libicee kernel-headers ldd gdb "
IMAGE_INSTALL += " gstreamer-dev gst-plugins-base-dev libicee-dev libv4l-dev curl-dev xenomai-dev "
IMAGE_INSTALL += " libgps "

IMAGE_PREPROCESS_COMMAND += "install -d ${IMAGE_ROOTFS}/root/.ssh;"
# IMAGE_PREPROCESS_COMMAND += "install -c -m 600 ${FILE_DIRNAME}/files/authorized_keys ${IMAGE_ROOTFS}/root/.ssh/authorized_keys;"

IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/interfaces ${IMAGE_ROOTFS}/etc/network/;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 600 ${FILE_DIRNAME}/files/wpa_supplicant.conf ${IMAGE_ROOTFS}/etc/;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/ar9170.fw ${IMAGE_ROOTFS}/lib/firmware/;"

RDEPENDS_kernel-base = ""

export IMAGE_BASENAME = "veter-image"
