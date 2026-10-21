param(
    [Parameter(ValueFromRemainingArguments = $true)]
    [string[]] $MavenArgs
)

$ErrorActionPreference = 'Stop'
$projectRoot = (Resolve-Path (Join-Path $PSScriptRoot '..\..')).Path
$mavenVersion = '3.9.16'
$archiveName = "apache-maven-$mavenVersion-bin.zip"
$distributionUrl = "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/$mavenVersion/$archiveName"
$userHome = if ($env:MAVEN_USER_HOME) { $env:MAVEN_USER_HOME } else { Join-Path $env:USERPROFILE '.m2' }
$distributionRoot = Join-Path $userHome "wrapper\dists\apache-maven-$mavenVersion"
$mavenHome = Join-Path $distributionRoot "apache-maven-$mavenVersion"
$mavenCommand = Join-Path $mavenHome 'bin\mvn.cmd'

if (-not (Test-Path $mavenCommand)) {
    New-Item -ItemType Directory -Force -Path $distributionRoot | Out-Null
    $archivePath = Join-Path $distributionRoot $archiveName
    Write-Host "Downloading Apache Maven $mavenVersion..."
    Invoke-WebRequest -Uri $distributionUrl -OutFile $archivePath
    Expand-Archive -LiteralPath $archivePath -DestinationPath $distributionRoot -Force
    Remove-Item -LiteralPath $archivePath -Force
}

Set-Location $projectRoot
& $mavenCommand @MavenArgs
exit $LASTEXITCODE
