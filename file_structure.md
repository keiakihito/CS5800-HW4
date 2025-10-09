bridge/
└─ src/
   ├─ main/
   │  └─ java/
   │     └─ ecommerce/
   │        ├─ channels/                 # 実装側(Implementor)
   │        │  ├─ NotificationChannel.java
   │        │  ├─ EmailChannel.java
   │        │  ├─ SmsChannel.java
   │        │  └─ PushChannel.java
   │        ├─ payments/                 # 抽象側(Abstraction)
   │        │  ├─ PaymentNotification.java
   │        │  ├─ OnlinePaymentNotification.java
   │        │  ├─ CashOnDeliveryPayment.java
   │        │  └─ BitcoinPayment.java
   │        └─ app/
   │           └─ Main.java              # ドライバ
   └─ test/
      └─ java/
         └─ ecommerce/
            └─ BridgeDemoTest.java


decorator/
└─ src/
   ├─ main/
   │  └─ java/
   │     └─ restaurant/
   │        ├─ components/               # 具象コンポーネント (例: Coffee, Pizza)
   │        │  ├─ MenuItem.java          # Component(インターフェース/抽象)
   │        │  ├─ Coffee.java            # ConcreteComponent
   │        │  └─ Pizza.java             # ConcreteComponent
   │        ├─ decorators/               # デコレータ群
   │        │  ├─ MenuDecorator.java     # Base Decorator
   │        │  ├─ ExtraCheese.java       # ConcreteDecorator
   │        │  ├─ WhippedCream.java      # ConcreteDecorator
   │        │  └─ LargeSize.java         # ConcreteDecorator(サイズ拡張等)
   │        └─ app/
   │           └─ Main.java              # ドライバ
   └─ test/
      └─ java/
         └─ restaurant/
            └─ DecoratorDemoTest.java
