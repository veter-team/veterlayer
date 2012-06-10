#inherit image
require recipes-images/angstrom/systemd-image.bb

DEPENDS =+ " task-base task-sdk-target gst-plugins-base gst-plugins-good gst-plugins-bad gst-plugins-ugly "

IMAGE_LINGUAS = ""

# Kernel related modules and staff
IMAGE_INSTALL += " kernel-module-ar9170usb kernel-module-easycap kernel-module-8712u kernel-module-uvcvideo "
IMAGE_INSTALL += " kernel-module-usbserial kernel-module-pl2303 "
IMAGE_INSTALL += " ti-codecs-omap3530 ti-cmem-module ti-dsplink-module ti-lpm-module ti-sdma-module "

# GStreamer related installs
IMAGE_INSTALL += " gstreamer gst-plugins-base gst-plugins-base-apps gst-plugins-base-app gst-plugins-base-ffmpegcolorspace"
IMAGE_INSTALL += " gst-plugins-good-video4linux2 gst-plugins-good-rtp gst-plugins-good-videomixer gst-plugins-base-videoscale gst-plugins-good-videobox "
IMAGE_INSTALL += " gstreamer-ti "

# Several usefull utilities
IMAGE_INSTALL += " mtd-utils devmem2 i2c-tools wireless-tools wpa-supplicant opencv-apps avahi avahi-daemon avahi-dnsconfd ntp tzdata "

# Development environment
# Basic dev tools
IMAGE_INSTALL += " task-sdk-target git cmake kernel-headers ldd gdb "
# Gstreamer development environment
IMAGE_INSTALL += " gstreamer-dev gst-plugins-base-dev libv4l-dev "
# Misc library
# Ice embedded - commented in this image as replaced by full Ice bellow
# IMAGE_INSTALL += " slice2cppe icee-slice libicee libicee-dev "

# GPSD, if needed
# IMAGE_INSTALL += " gpsd gps-utils libgps curl-dev "
# Xenomai and development
IMAGE_INSTALL += " xenomai xenomai-dev "
# conmann utilities 
IMAGE_INSTALL += " connman-tools connman-tests python-dbus python-pygobject "

# Using the robot for labs
# Python and company
IMAGE_INSTALL += " python python-dev python-datetime python-stringold python-threading "
IMAGE_INSTALL += " mcpp zeroc-ice zeroc-ice-dev zeroc-ice-slice python-zeroc-ice python-zeroc-ice-dev "

IMAGE_PREPROCESS_COMMAND += "install -d ${IMAGE_ROOTFS}/root/.ssh;"
IMAGE_PREPROCESS_COMMAND += "install -d ${IMAGE_ROOTFS}/lib/firmware;"
IMAGE_PREPROCESS_COMMAND += "install -d ${IMAGE_ROOTFS}/var/lib/connman;"

# IMAGE_PREPROCESS_COMMAND += "install -c -m 600 ${FILE_DIRNAME}/files/authorized_keys ${IMAGE_ROOTFS}/root/.ssh/authorized_keys;"

# IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/interfaces ${IMAGE_ROOTFS}/etc/network/;"
# IMAGE_PREPROCESS_COMMAND += "install -c -m 600 ${FILE_DIRNAME}/files/wpa_supplicant.conf ${IMAGE_ROOTFS}/etc/;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/ar9170.fw ${IMAGE_ROOTFS}/lib/firmware/;"

IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/settings ${IMAGE_ROOTFS}/var/lib/connman/;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${FILE_DIRNAME}/files/default.config ${IMAGE_ROOTFS}/var/lib/connman/;"

# Fix inittab for new kernel
# IMAGE_PREPROCESS_COMMAND += "sed -i 's/ttyS/ttyO/g' ${IMAGE_ROOTFS}/etc/inittab;"

RDEPENDS_kernel-base = ""

DEFAULT_TIMEZONE="Europe/Berlin"

export IMAGE_BASENAME = "veter-image"
