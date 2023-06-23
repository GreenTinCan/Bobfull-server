package server.bobfull.infra.aws.s3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import server.bobfull.infra.aws.s3.model.S3Image;

public class AwsS3ImageDtos {
    @Data
    @NoArgsConstructor
    public static class ImageDto {

        private String folderName;

        private String fileUrl;

        private String fileType;

        public ImageDto(S3Image image) {
            this.folderName = image.getFolderName();
            this.fileUrl = image.getFileUrl();
            this.fileType = image.getFileType();
        }
    }
    @Data
    @NoArgsConstructor
    public static class ImagesResponseDto {
        private String fileUrls;
        public ImagesResponseDto(ImageDto imageDto) {
            this.fileUrls = imageDto.fileUrl;
        }
    }
}
