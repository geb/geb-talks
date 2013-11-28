package util

import geb.Browser

class Pause {

    static void pause(Browser browser) {
        browser.js.exec """
            (function() {
                window.__gebPaused = true;
                var div = document.createElement("div");
                div.setAttribute('style', "\\
                    position: absolute; top: 0px;\\
                    z-index: 3000;\\
                    padding: 10px;\\
                    background-color: red;\\
                    border: 2px solid black;\\
                    border-radius: 2px;\\
                    text-align: center;\\
                ");

                var unpause = function() {
                    window.__gebPaused = false;
                    div.parentNode.removeChild(div);
                };

                var button = document.createElement("button");
                button.innerHTML = "Unpause Geb";
                button.onclick = function() {
                    unpause();
                };

                \$(document).keypress(function(e) {
                    if (e.which == 13) {
                        unpause();
                    }
                });

                button.setAttribute("style", "\\
                    font-weight: bold;\\
                ");

                div.appendChild(button);
                document.getElementsByTagName("body")[0].appendChild(div);
           })();
       """

        browser.waitFor(300) { !browser.js.__gebPaused }
    }

}
