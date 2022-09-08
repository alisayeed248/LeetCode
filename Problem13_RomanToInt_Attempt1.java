class Solution { // Works but inelegant and long, must be a way to shorten it --> actual runtime and memory is efficient
    public int romanToInt(String s) {
        // let's make a case where we can first identify if it's 1 to 4
        int value = 0;
        for (int i = 0; i < s.length(); i++) { // naiive approach: iterate through each character
            if (i < s.length() - 1) { // i = 5, s.length() = 7; 
                if (s.charAt(i) == 'I') { 
                    if (s.charAt(i + 1) == 'V') {
                        value = value + 4;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'X') {
                        value = value + 9;
                        i++;
                    }
                    else {
                        value = value + 1;
                    }
                }
                else if (s.charAt(i) =='V') {
                    value = value + 5;
                }
                else if (s.charAt(i) == 'X') {
                    if (s.charAt(i + 1) == 'L') {
                        value = value + 40;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'C') {
                        value = value + 90;
                        i++;
                    }
                    else {
                        value = value + 10;
                    }
                }
                else if (s.charAt(i) == 'L') {
                    value = value + 50;
                }
                else if (s.charAt(i) == 'C') {
                    if (s.charAt(i + 1) == 'D') {
                        value = value + 400;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'M') {
                        value = value + 900;
                        i++;
                    }
                    else {
                        value = value + 100;
                    }
                }
                else if (s.charAt(i) == 'D') {
                    value = value + 500;
                }
                else if (s.charAt(i) == 'M') {
                    value = value + 1000;
                }
            }
            else {
                if (s.charAt(i) == 'I') { 
                    value = value + 1;
                }
                else if (s.charAt(i) == 'V') {
                    value = value + 5;
                }
                else if (s.charAt(i) == 'X') {
                    value = value + 10;
                }
                else if (s.charAt(i) == 'L') {
                    value = value + 50;
                }
                else if (s.charAt(i) == 'C') {
                    value = value + 100;
                }
                else if (s.charAt(i) == 'D') {
                    value = value + 500;
                }
                else if (s.charAt(i) == 'M') {
                    value = value + 1000;
                }
            }
        }
        return value;
    }    
}

