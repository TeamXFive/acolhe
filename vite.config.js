import { defineConfig } from "vite";

export default defineConfig({
    // root: "app",
    build: {
        outDir: "../dist",
        emptyOutDir: true,
    },
    publicDir: "public",
});
