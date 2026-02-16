package com.mojang.rubydung.level;

import java.util.Random;

/* JADX INFO: loaded from: pre-Classic rd-160052.jar:com/mojang/rubydung/level/PerlinNoiseFilter.class */
public class PerlinNoiseFilter {
    int levels;
    Random random = new Random();
    int seed = this.random.nextInt();
    int fuzz = 16;

    public PerlinNoiseFilter(int levels) {
        this.levels = 0;
        this.levels = levels;
    }

    public int[] read(int width, int height) {
        Random random = new Random();
        int[] tmp = new int[width * height];
        int level = this.levels;
        int step = width >> level;
        int i = 0;
        while (true) {
            int y = i;
            if (y >= height) {
                break;
            }
            int i2 = 0;
            while (true) {
                int x = i2;
                if (x >= width) {
                    break;
                }
                tmp[x + (y * width)] = (random.nextInt(256) - 128) * this.fuzz;
                i2 = x + step;
            }
            i = y + step;
        }
        int i3 = width >> level;
        while (true) {
            int step2 = i3;
            if (step2 <= 1) {
                break;
            }
            int val = 256 * (step2 << level);
            int ss = step2 / 2;
            int i4 = 0;
            while (true) {
                int y2 = i4;
                if (y2 >= height) {
                    break;
                }
                int i5 = 0;
                while (true) {
                    int x2 = i5;
                    if (x2 >= width) {
                        break;
                    }
                    int ul = tmp[((x2 + 0) % width) + (((y2 + 0) % height) * width)];
                    int ur = tmp[((x2 + step2) % width) + (((y2 + 0) % height) * width)];
                    int dl = tmp[((x2 + 0) % width) + (((y2 + step2) % height) * width)];
                    int dr = tmp[((x2 + step2) % width) + (((y2 + step2) % height) * width)];
                    tmp[x2 + ss + ((y2 + ss) * width)] = (((((ul + dl) + ur) + dr) / 4) + random.nextInt(val * 2)) - val;
                    i5 = x2 + step2;
                }
                i4 = y2 + step2;
            }
            int i6 = 0;
            while (true) {
                int y3 = i6;
                if (y3 >= height) {
                    break;
                }
                int i7 = 0;
                while (true) {
                    int x3 = i7;
                    if (x3 >= width) {
                        break;
                    }
                    int c = tmp[x3 + (y3 * width)];
                    int r = tmp[((x3 + step2) % width) + (y3 * width)];
                    int d = tmp[x3 + (((y3 + step2) % width) * width)];
                    int mu = tmp[((x3 + ss) & (width - 1)) + ((((y3 + ss) - step2) & (height - 1)) * width)];
                    int ml = tmp[(((x3 + ss) - step2) & (width - 1)) + (((y3 + ss) & (height - 1)) * width)];
                    int m = tmp[((x3 + ss) % width) + (((y3 + ss) % height) * width)];
                    int u = (((((c + r) + m) + mu) / 4) + random.nextInt(val * 2)) - val;
                    int l = (((((c + d) + m) + ml) / 4) + random.nextInt(val * 2)) - val;
                    tmp[x3 + ss + (y3 * width)] = u;
                    tmp[x3 + ((y3 + ss) * width)] = l;
                    i7 = x3 + step2;
                }
                i6 = y3 + step2;
            }
            i3 = step2 / 2;
        }
        int[] result = new int[width * height];
        for (int y4 = 0; y4 < height; y4++) {
            for (int x4 = 0; x4 < width; x4++) {
                result[x4 + (y4 * width)] = (tmp[(x4 % width) + ((y4 % height) * width)] / 512) + 128;
            }
        }
        return result;
    }
}
