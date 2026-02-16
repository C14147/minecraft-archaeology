# Minecraft Version Archive

Welcome to the **Minecraft Version Archive** – a curated collection of resources for exploring and studying the earliest versions of Minecraft. This repository is dedicated to preserving the history of Minecraft's development, providing tools and data for **archaeological** analysis of pre‑release and classic versions.

## 📦 Contents

The archive is organized into three main directories:

- **`decompiled_src/`** – Decompiled source code of various Minecraft versions, generated using tools like [FernFlower](https://github.com/fesh0r/fernflower) or [MCP](https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-coder-pack). These sources are meant for educational and historical study.
- **`tools/`** – Auxiliary tools for Minecraft version archaeology. This includes scripts and utilities for:
  - Extracting and inspecting version JARs
  - Analysing NBT data from early saves
  - Comparing differences between version iterations
  - Patching or modifying old executables (for research only)
- **`jars/`** – Original JAR files of selected Minecraft versions. **These files are the property of Mojang Studios** and are provided here solely for archival and research purposes. They should not be used for any commercial activity.

## 🔍 Purpose

The goal of this project is to make it easier for enthusiasts, modders, and historians to explore the evolution of Minecraft. By providing both the original binaries and decompiled source code, along with dedicated analysis tools, we hope to foster a deeper understanding of how the game grew from its humble beginnings.

## ⚠️ Legal Disclaimer

- All Minecraft JAR files included in this repository are the property of **Mojang Studios (a subsidiary of Microsoft)**. They are provided here **as‑is** for **historical and educational use only**.
- If you are a Mojang representative and believe any content violates your rights, please open an issue and we will address it promptly.
- The decompiled source code is **not** the official Minecraft source and may contain inaccuracies. It is generated automatically for reference.
- Tools and scripts in the `tools/` directory are released under the **MIT License** (see [LICENSE](LICENSE)), unless otherwise noted.

## 🚀 Getting Started

1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/minecraft-version-archive.git
   cd minecraft-version-archive
   ```

2. **Explore the JARs**  
   JAR files are located in `jars/`. You can run them with the appropriate Java version (usually Java 8 for older releases).  
   *Note: Some extremely old versions may require Java 6 or even Java 5.*

3. **Examine the decompiled source**  
   Browse `decompiled_src/` to see the code structure of each version. Keep in mind that decompiled code may not compile directly due to missing dependencies or obfuscation artifacts.

4. **Use the tools**  
   Each tool in `tools/` should have its own README or inline documentation. Many are simple Python or shell scripts – check the comments for usage examples.

## 🤝 Contributing

Contributions are welcome! You can help by:

- Adding decompiled sources for missing versions.
- Improving or creating new archaeological tools.
- Submitting corrections to the decompiled code (if you verify it against official sources).
- Reporting issues or suggesting improvements.

**Please note:**  
- Do **not** upload any JAR files that are not already part of the official Minecraft releases.
- When adding decompiled code, clearly indicate the version and the tool used for decompilation.
- Follow the existing code style and include documentation where appropriate.

## 📜 License

- The `tools/` directory and all original scripts are licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.
- The decompiled source code in `decompiled_src/` is provided for reference only and inherits the copyright of the original Minecraft game (owned by Mojang Studios). It is not covered by the MIT license.
- The JAR files in `jars/` are the property of Mojang Studios and are not subject to this repository's license.

---

**Happy digging!** 🧱⛏️  
*Preserving the past, one block at a time.*