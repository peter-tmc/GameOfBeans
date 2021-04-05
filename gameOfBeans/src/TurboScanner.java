/*
   Copyright 2021, Tiago Teles <gpl@tteles.dev>
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
class TurboScanner{
	BufferedReader br;
	public TurboScanner(InputStream in){
		br = new BufferedReader(new InputStreamReader(in));
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	public String next() throws IOException{
		int i = 0;
		char ascii = '_';
		char[] chars = new char[13];
		while (ascii != ' ' && ascii != '\n') {
			ascii = (char) br.read();
			chars[i++] = ascii;
		}
		return new String(chars).trim();
	}
	public String nextLine() throws IOException{
		return br.readLine();
	}
	public void close() throws IOException{
		br.close();
	}
}
