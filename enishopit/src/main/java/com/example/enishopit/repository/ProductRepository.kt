package com.example.enishopit.repository

import com.example.enishopit.Product

object ProductRepository {
    private val _products = listOf(
        Product(id= 1L,"Smartphone Pro Max", "https://picsum.photos/seed/smartphonepromax/500/800", 1099.99f,"Smartphone"),
        Product(id= 2L,"Smartphone Lite", "https://picsum.photos/seed/smartphonelite/500/800", 499.99f,"Smartphone"),
        Product(id= 3L,"Gaming Laptop 15\"", "https://picsum.photos/seed/gaming-laptop15inch/500/800", 1499.99f,"Laptop"),
        Product(id= 4L,"Ultrabook Thin 13\"", "https://picsum.photos/seed/ultrabook-thin13inch/500/800", 999.99f,"Laptop"),
        Product(id= 5L,"Tablet 10\" Plus", "https://picsum.photos/seed/tablet10plus/500/800", 599.99f,"Tablet"),
        Product(id= 6L,"Tablet 8\" Mini", "https://picsum.photos/seed/tablet8mini/500/800", 399.99f,"Tablet"),
        Product(id=7L ,"E-Reader Touch", "https://picsum.photos/seed/e-readertouch/500/800", 129.99f,"Tablet"),
        Product(id=8L ,"Smartwatch 4", "https://picsum.photos/seed/smartwatch-4/500/800", 249.99f,"Watch"),
        Product(id=9L ,"Gaming Headset", "https://picsum.photos/seed/gamingheadset/500/800", 79.99f,"Headphones"),
        Product(id=10L ,"Wireless Mouse", "https://picsum.photos/seed/wirelessmouse/500/800", 49.99f,"Mouse"),
        Product(id=11L ,"Wireless Keyboard", "https://picsum.photos/seed/wirelesskeyboard/500/800", 59.99f,"Keyboard"),
        Product(id=12L ,"USB-C Hub", "https://picsum.photos/seed/usb-c-hub/500/800", 39.99f,"Accessories"),
        Product(id=13L ,"Portable SSD 1TB", "https://picsum.photos/seed/portable-ssd1tb/500/800", 109.99f,"Accessories"),
        Product(id=14L ,"Monitor 24\" LED", "https://picsum.photos/seed/monitor-24inchled/500/800", 199.99f,"Monitor"),
        Product(id=15L ,"Graphics Tablet", "https://picsum.photos/seed/graphicstablet/500/800", 299.99f,"Tablet"),
        Product(id=16L ,"External GPU", "https://picsum.photos/seed/external-gpu/500/800", 599.99f,"GPU"),
        Product(id=17L ,"Smartphone Stand", "https://picsum.photos/seed/smartphonestand/500/800", 19.99f,"Accesories"),
        Product(id=18L ,"Laptop Cooling Pad", "https://picsum.photos/seed/laptop-coolingpad/500/800", 29.99f,"Laptop"),
        Product(id=19L ,"Noise Cancelling Headphones", "https://picsum.photos/seed/noisecancelling-headphones/500/800", 349.99f,"Headphones"),
        Product(id=20L ,"Bluetooth Speaker", "https://picsum.photos/seed/bluetoothspeaker/500/800", 99.99f,"Speaker"),
        Product(id=21L ,"Smart Home Hub", "https://picsum.photos/seed/smart-homehub/500/800", 89.99f,"Smartphone"),
        Product(id=22L ,"Wireless Charger", "https://picsum.photos/seed/wirelesscharger/500/800", 29.99f,"Charger"),
        Product(id=23L ,"VR Headset", "https://picsum.photos/seed/vr-headset/500/800", 399.99f,"VR"),
        Product(id=24L ,"Action Camera", "https://picsum.photos/seed/action-camera/500/800", 199.99f,"Camera"),
        Product(id=25L ,"Digital Pen", "https://picsum.photos/seed/digital-pen/500/800", 99.99f,"Pen"),
        Product(id=26L ,"Gaming Mouse Pad", "https://picsum.photos/seed/gaming-mousepad/500/800", 19.99f,"Mouse"),
        Product(id=27L ,"Docking Station", "https://picsum.photos/seed/dockingstation/500/800", 99.99f,"Accesories"),
        Product(id=28L ,"Fitness Tracker", "https://picsum.photos/seed/fitnesstracker/500/800", 149.99f,"Watch"),
        Product(id=29L ,"Projector 4K", "https://picsum.photos/seed/projector-4k/500/800", 899.99f,"Projector"),
        Product(id=30L ,"Webcam HD", "https://picsum.photos/seed/webcam-hd/500/800", 69.99f,"Webcam"),
        Product(id=31L ,"Smart Light Bulb", "https://picsum.photos/seed/smart-lightbulb/500/800", 14.99f,"Accesories"),
        Product(id=32L ,"Wireless Earbuds", "https://picsum.photos/seed/wirelessearbuds/500/800", 129.99f,"Headphones"),
        Product(id=33L ,"Streaming Mic", "https://picsum.photos/seed/streaming-mic/500/800", 99.99f,"Microphone"),
        Product(id=34L ,"Dual Monitor Stand", "https://picsum.photos/seed/dual-monitorstand/500/800", 59.99f,"Monitor")
    )
    fun getById(id:Long) = _products.find { it.id == id }
    fun  getAll() = _products
}