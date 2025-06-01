import { defineConfig } from "vite";

export default defineConfig({
    root: "app",
    build: {
        // Output directory for the built files
        outDir: "../dist",
        // Make sure assets have the correct paths
        emptyOutDir: true,
    },
    publicDir: "public",
});
