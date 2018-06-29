# karabiner

karabiner 설정파일 경로:

	~/.config/karabiner/assets/complex_modifications

my.json:
```json
    {
      "description": "PC-Style Copy/Paste/Cut",
      "manipulators": [
        {
          "type": "basic",
          "from": {
            "key_code": "c",
            "modifiers": { 
              "mandatory": [
                "control"
              ],
              "optional": [
                "any"
              ]
            }
          },
          "to": [
            { 
              "key_code": "c",
              "modifiers": [
                "left_command"
              ]
            }
          ],
          "conditions": [
            {
              "type": "frontmost_application_unless",
              "bundle_identifiers": [
                "^com\\.microsoft\\.rdc$",
                "^com\\.microsoft\\.rdc\\.mac$",
                "^com\\.microsoft\\.rdc\\.macos$",
                "^com\\.microsoft\\.rdc\\.osx\\.beta$",
                "^net\\.sf\\.cord$",
                "^com\\.thinomenon\\.RemoteDesktopConnection$",
                "^com\\.itap-mobile\\.qmote$",
                "^com\\.nulana\\.remotixmac$",
                "^com\\.p5sys\\.jump\\.mac\\.viewer$",
                "^com\\.p5sys\\.jump\\.mac\\.viewer\\.web$",
                "^com\\.teamviewer\\.TeamViewer$",
                "^com\\.vmware\\.horizon$",
                "^com\\.2X\\.Client\\.Mac$",
                "^com\\.vmware\\.fusion$",
                "^com\\.vmware\\.horizon$",
                "^com\\.vmware\\.view$",
                "^com\\.parallels\\.desktop$",
                "^com\\.parallels\\.vm$",
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE4MTgxNDYyNzIsNDA5NDY3MjU4LC0xNT
AwODM3NzczXX0=
-->