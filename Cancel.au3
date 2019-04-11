Sleep(10000)
   Local $hIE = WinGetHandle("[Class:IEFrame]")
   Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:DirectUIHWND1]")

	If WinExists($hIE,"") Then
	  WinActivate($hIE,"")
	  ControlSend($hIE ,"",$hCtrl,"{F6}")          ; Gives focus to Open Button
	  Sleep(2200)
	  ControlSend($hIE ,"",$hCtrl,"{TAB}")          ; Gives focus to Save Button
	  Sleep(2200)
	  ControlSend($hIE ,"",$hCtrl,"{TAB}")          ; Gives focus to Open folder
	  Sleep(2200)
	  ControlSend($hIE ,"",$hCtrl,"{enter}")
      WinClose($hWnd3)
	Else
	  MsgBox(4096, "Error", "Ошибка загрузки", 1)
	  WinActivate($hIE,"")
	  WinClose($hIE,"")
	EndIf
Exit

