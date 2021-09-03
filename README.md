# README #

 - Necessário ter o java instalado na máquina. 
 - Algum emulador android
 - Appium instalado para inicializar o server local e inspecionar o app mobile.

### Lista de comandos usados em cmd: ###
* Mostrar androids que foram criados:

 - Comando: emulator -list-avds

 - Exemplo: C:\Users\Orlando>emulator -list-avds

Nexus_5_API_30
Pixel_2_API_24
### ##############################################
* Direciona você para a pasta do android home para executa alguns comandos, como abrir o emulador.

 - Comando: cd %ANDROID_HOME% 

 - Exemplo:	
T:\Arquivos e Programas x86\Android\User\AppData\Local\Android\Sdk>cd tools

T:\Arquivos e Programas x86\Android\User\AppData\Local\Android\Sdk\tools>
	
Obs: caso seja necessario entre na pasta tools para abrir o emulador.
### ###############################################
* Abrir o emulador android  
Obs: Entre na pasta tools

 - Comando: emulator @Pixel_2_API_24

Com isso irá abrir o emulador.

### ################################################
* Listar dispositivos conectados/ligados.

 - Comando: adb devices 

Exemplo:
C:\Users\Orlando>adb devices

daemon started successfully

List of devices attached

emulator-5554   device
emulator-5556   device
### #################################################

* Abrir o inspetor UIAUTOMATORVIEWER para pegar os locators

 - comando: uiautomatorviewer

Exemplo:
C:\Users\Orlando>uiautomatorviewer

Com esse comando simples, irá abrir o inspetor para localizar os Locators
### #################################################
* Dependencias do pom.xml
	- 
    <dependencies>
		<dependency>
			<groupId>io.appium</groupId>
			<artifactId>java-client</artifactId>
			<version>7.5.1</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<scope>compile</scope>
		</dependency>
		
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.5</version>
		</dependency>
	</dependencies>

### Extra: Link com vários exemplos de busca por locators ###
https://www.red-gate.com/simple-talk/development/dotnet-development/xpath-css-dom-and-selenium-the-rosetta-stone/

### #################################################
### Proprietário ###

* Orlando de Oliveira
* https://www.linkedin.com/in/orlando-junior-869882164/